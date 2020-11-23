package com.hao.esClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;

/**
 * @author zrh
 * @version 1.0
 * @date 2020-11-23 16:42
 **/
public class MachQuery {
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
     * 如果数据较多，就只线上10条 不会分词
     * */
    public void matchAllQuery() throws IOException {
        SearchRequest request = new SearchRequest(index);
        request.types(type);

        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.size(20);
        builder.query(QueryBuilders.matchAllQuery());
        request.source(builder);

        SearchResponse response = client.search(request, RequestOptions.DEFAULT);

        for(SearchHit hit: response.getHits()){
            System.out.println(hit.getSourceAsMap());
        }
    }

    /**
     * 如果数据较多，就只线上10条 不会分词
     * */
    public void matchQuery() throws IOException {
        SearchRequest request = new SearchRequest(index);
        request.types(type);

        SearchSourceBuilder builder = new SearchSourceBuilder();
        //条件查询
        builder.query(QueryBuilders.matchQuery("smsContent","收货安装"));
        request.source(builder);

        SearchResponse response = client.search(request, RequestOptions.DEFAULT);

        for(SearchHit hit: response.getHits()){
            System.out.println(hit.getSourceAsMap());
        }
    }

    /**
     * 如果数据较多，就只线上10条 不会分词
     * */
    public void matchBooleanQuery() throws IOException {
        SearchRequest request = new SearchRequest(index);
        request.types(type);

        SearchSourceBuilder builder = new SearchSourceBuilder();
        //条件查询 smsContent = 中国 and   smsContent =健康
        builder.query(QueryBuilders.matchQuery("smsContent","中国 健康").operator(Operator.AND));
        request.source(builder);

        SearchResponse response = client.search(request, RequestOptions.DEFAULT);

        for(SearchHit hit: response.getHits()){
            System.out.println(hit.getSourceAsMap());
        }
    }

    /**
     * 如果数据较多，就只线上10条 不会分词
     * */
    public void multiMatchQuery() throws IOException {
        SearchRequest request = new SearchRequest(index);
        request.types(type);

        SearchSourceBuilder builder = new SearchSourceBuilder();
        //条件查询 smsContent = 中国 or   smsContent =中国
        builder.query(QueryBuilders.multiMatchQuery("中国","smsContent","province"));
        request.source(builder);

        SearchResponse response = client.search(request, RequestOptions.DEFAULT);

        for(SearchHit hit: response.getHits()){
            System.out.println(hit.getSourceAsMap());
        }
    }
}
