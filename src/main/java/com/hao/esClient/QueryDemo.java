package com.hao.esClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;
import java.util.Map;

/**
 * @author zrh
 * @version 1.0
 * @date 2020-11-23 15:23
 * 查询
 **/
public class QueryDemo {
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
     * 直接匹配，不会分词匹配
     * */
    public void termQuery() throws IOException {
        //创建request
        SearchRequest request = new SearchRequest(index);
        request.types(type);
        //指定查询条件
        SearchSourceBuilder build = new SearchSourceBuilder();
        build.from(0);
        build.size(2);
        build.query(QueryBuilders.termQuery("province", "北京"));
        //执行查询
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        //获取到_source中的数据，并展示
        for (SearchHit hit:response.getHits()){
            Map<String,Object> result = hit.getSourceAsMap();
            System.out.println(result);
        }

    }


    /**
     * 直接匹配，不会分词匹配
     * terms:where province = 北京 or  province = 北京 or (或者相当于in(?,?,?))
     * */
    public void termsQuery() throws IOException {
        //创建request
        SearchRequest request = new SearchRequest(index);
        request.types(type);
        //指定查询条件
        SearchSourceBuilder build = new SearchSourceBuilder();
        build.from(0);
        build.size(2);
        build.query(QueryBuilders.termsQuery("province", "北京","山西"));
        //执行查询
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        for (SearchHit hit:response.getHits()){
            Map<String,Object> result = hit.getSourceAsMap();
            System.out.println(result);
        }
        //获取到_source中的数据，并展示
    }


}
