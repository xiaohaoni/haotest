package com.hao.esClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.*;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.*;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryRequest;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;

import java.io.IOException;
import java.util.Map;

/**
 * 其他查询
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-23 18:44
 **/
public class OtherQuery {
    ObjectMapper mapper = new ObjectMapper();
    RestHighLevelClient client = EsClient.getClient();
    /**
     * 索引
     */
    String index = "sms-logs-index";
    /**
     * 类型
     */
    String type = "sms-logs-type";

    /**
     * id查询
     */
    public void findById() throws IOException {
        GetRequest request = new GetRequest(index, type, "1");

        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        System.out.println(response.getSourceAsMap());
    }

    /**
     * id查询
     */
    public void findByIds() throws IOException {
        SearchRequest request = new SearchRequest(index);
        request.types(type);
        SearchSourceBuilder builder = new SearchSourceBuilder();
        //查询条件
        builder.query(QueryBuilders.idsQuery().addIds("1", "2"));
        request.source(builder);

        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        for (SearchHit hit : response.getHits()) {
            System.out.println(hit.getSourceAsMap());
        }
    }


    /**
     * Prefix
     */
    public void findByPrefix() throws IOException {
        SearchRequest request = new SearchRequest(index);
        request.types(type);
        SearchSourceBuilder builder = new SearchSourceBuilder();
        //查询条件 corpName  like '河马%'
        builder.query(QueryBuilders.prefixQuery("corpName", "河马"));
        request.source(builder);

        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        for (SearchHit hit : response.getHits()) {
            System.out.println(hit.getSourceAsMap());
        }
    }

    /**
     * Prefix
     */
    public void findByFuzzy() throws IOException {
        SearchRequest request = new SearchRequest(index);
        request.types(type);
        SearchSourceBuilder builder = new SearchSourceBuilder();
        /* 查询条件 corpName  like '河马%' 需要前两个字需要正确
         * 数据库中：河马鲜生
         * */
        builder.query(QueryBuilders.fuzzyQuery("corpName", "河马先生").prefixLength(2));
        request.source(builder);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        for (SearchHit hit : response.getHits()) {
            System.out.println(hit.getSourceAsMap());
        }
    }

    /**
     * Wildcard
     * 通配符查询
     */
    public void findByWildcard() throws IOException {
        SearchRequest request = new SearchRequest(index);
        request.types(type);
        SearchSourceBuilder builder = new SearchSourceBuilder();
        /* 查询条件 corpName  like '河马?*' 需要前两个字需要正确
         * 数据库中：河马鲜生
         * */
        builder.query(QueryBuilders.wildcardQuery("corpName", "河马?*"));
        request.source(builder);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        for (SearchHit hit : response.getHits()) {
            System.out.println(hit.getSourceAsMap());
        }
    }

    /**
     * range 范围查询
     */
    public void findByRange() throws IOException {
        SearchRequest request = new SearchRequest(index);
        request.types(type);
        SearchSourceBuilder builder = new SearchSourceBuilder();
        /* 查询条件 corpName  like '河马?*' 需要前两个字需要正确
         * 数据库中：河马鲜生
         * */
        builder.query(QueryBuilders.rangeQuery("fee").lt(10).gt(5));
        request.source(builder);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        for (SearchHit hit : response.getHits()) {
            System.out.println(hit.getSourceAsMap());
        }
    }

    /**
     * ragexp 范围查询
     */
    public void findByRagexp() throws IOException {
        SearchRequest request = new SearchRequest(index);
        request.types(type);
        SearchSourceBuilder builder = new SearchSourceBuilder();
        /* 查询条件 corpName  like '河马?*' 需要前两个字需要正确
         * 数据库中：河马鲜生
         * */
        builder.query(QueryBuilders.regexpQuery("mobile", "139[0-9]{8}"));
        request.source(builder);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        for (SearchHit hit : response.getHits()) {
            System.out.println(hit.getSourceAsMap());
        }
    }


    /**
     * scroll 范围查询
     */
    public void scrollQuery() throws IOException {
        // 1.创建searchRequest
        SearchRequest request = new SearchRequest(index);
        request.types(type);
        //2.指定scroll信息
        request.scroll(TimeValue.timeValueMinutes(1L));
        //3.指定查询信息
        SearchSourceBuilder build = new SearchSourceBuilder();
        build.size(4);
        build.sort("fee", SortOrder.DESC);
        build.query(QueryBuilders.matchAllQuery());
        request.source(build);
        //4.获取返回结果scrollId,source
        SearchResponse resp = client.search(request, RequestOptions.DEFAULT);
        String scrollId = resp.getScrollId();
        //获取到_source中的数据，并展示
        // ------------------首页-------
        for (SearchHit hit : resp.getHits()) {
            Map<String, Object> result = hit.getSourceAsMap();
            System.out.println(result);
        }
        while (true) {
            //5.循环 创建SearchScrollRequest
            SearchScrollRequest scrollRequest = new SearchScrollRequest(scrollId);
            //6.指定scrollId
            scrollRequest.scroll(TimeValue.timeValueMinutes(1l));
            //7.执行查询话区返回结果
            SearchResponse searchResponse = client.scroll(scrollRequest, RequestOptions.DEFAULT);
            //8判断是否查询到数据，输出
            SearchHit[] hits = searchResponse.getHits().getHits();
            if (hits != null && hits.length > 0) {
                // ------------------下一页-------
                for (SearchHit hit : hits) {
                    //9判断灭偶查询到数据 退出循环
                    Map<String, Object> result = hit.getSourceAsMap();
                    System.out.println(result);
                }

            }else {
                break;
            }
            //10 .创建clearScrollRequest
            ClearScrollRequest clearScrollRequest = new ClearScrollRequest();
            //11 指定scrollId
            clearScrollRequest.addScrollId(scrollId);
            //12删除scrollId
            ClearScrollResponse clearScrollResponse = client.clearScroll(clearScrollRequest,RequestOptions.DEFAULT);
            //13输出结果
            System.out.println(clearScrollResponse.isSucceeded());


        }


    }

    /**
     * 查询删除 delete -by-query
     * */
    public void deleteByQuery() throws IOException {
        DeleteByQueryRequest request = new DeleteByQueryRequest(index);
        request.types(type);
        request.setQuery(QueryBuilders.rangeQuery("fee").lt(4));
        BulkByScrollResponse response = client.deleteByQuery(request, RequestOptions.DEFAULT);
        System.out.println(response);
    }

    /**
     * 复合查询
     * */
    public void boolQuery() throws IOException {
        SearchRequest request = new SearchRequest(index);
        request.types(type);

        SearchSourceBuilder builder = new SearchSourceBuilder();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        //查询省份为武汉或者北京
        boolQueryBuilder.should(QueryBuilders.termQuery("province","武汉"));
        boolQueryBuilder.should(QueryBuilders.termQuery("province","北京"));
        //运营商不是联通
        boolQueryBuilder.should(QueryBuilders.termQuery("operatorId",2));
        //smsContent中包含中国和平安
        boolQueryBuilder.must(QueryBuilders.matchQuery("smsContent","中国"));
        boolQueryBuilder.must(QueryBuilders.matchQuery("smsContent","平安"));
        builder.query(boolQueryBuilder);
        request.source(builder);

        SearchResponse search = client.search(request, RequestOptions.DEFAULT);
        for (SearchHit hit : search.getHits().getHits()) {
            System.out.println(hit.getSourceAsMap());
        }


    }

    /**
     * 复合查询
     * 匹配第一个，如果还能匹配第二个，score*0.5
     * */
    public void bootSingQuery() throws IOException {
        SearchRequest request = new SearchRequest(index);
        request.types(type);

        SearchSourceBuilder builder = new SearchSourceBuilder();
        BoostingQueryBuilder boostingQueryBuilder = QueryBuilders.boostingQuery(
                QueryBuilders.matchQuery("smsContent","收货安装"),
                QueryBuilders.matchQuery("smsContent","王五")
        ).negativeBoost(0.5f);
        builder.query(boostingQueryBuilder);
        request.source(builder);

        SearchResponse search = client.search(request, RequestOptions.DEFAULT);
        for (SearchHit hit : search.getHits().getHits()) {
            System.out.println(hit.getSourceAsMap());
        }
    }

    public  void filter() throws IOException {
        SearchRequest request = new SearchRequest(index);
        request.types(type);
        SearchSourceBuilder builder = new SearchSourceBuilder();
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        boolQuery.filter(QueryBuilders.termQuery("smsContent","王五"));
        boolQuery.filter(QueryBuilders.rangeQuery("fee").lt(5));
        builder.query(boolQuery);
        request.source(builder);
        SearchResponse search = client.search(request, RequestOptions.DEFAULT);
        for (SearchHit hit : search.getHits().getHits()) {
            System.out.println(hit.getSourceAsMap());
        }

    }

    /**
     * 高亮查询
     * */
    public void highLightQuery() throws IOException {
        SearchRequest request = new SearchRequest(index);
        request.types(type);
        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.query(QueryBuilders.matchQuery("smsContent","盒马"));
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("smsContent",10)
                .preTags("<font color = 'red'")
                .postTags("</font>");
        builder.highlighter(highlightBuilder);
        request.source(builder);
        SearchResponse search = client.search(request, RequestOptions.DEFAULT);
        for (SearchHit hit : search.getHits().getHits()) {
            System.out.println(hit.getHighlightFields().get("smsContent"));
        }


    }


}
