package com.hao.esClient;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * @author zrh
 * @version 1.0
 * @date 2020-11-23 13:59
 **/
public class EsClient {
    public static RestHighLevelClient getClient() {
        //创建httpHost对象
        HttpHost httpHost = new HttpHost("192.168.109", 9200);
        //创建RestClientBuilder
        RestClientBuilder clientBuilder = RestClient.builder(httpHost);
        //创建RestHighLevelClient
        RestHighLevelClient client = new RestHighLevelClient(clientBuilder);

        return client;
    }


}
