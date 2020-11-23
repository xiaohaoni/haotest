package com.hao.esClient;

import groovy.transform.ASTTest;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.json.JsonXContent;

import java.io.IOException;

/**
 * @author zrh
 * @version 1.0
 * @date 2020-11-23 14:04
 **/
public class Demo1 {

    RestHighLevelClient client = EsClient.getClient();

    String index = "person";

    String type = "man";

    public void createIndex() throws IOException {
        //1准备关于索引的settings
       Settings.Builder settings = Settings.builder()
               //分片数
                .put("number_of_shards",3)
               //备份数
                .put("number_of_replicas",1);

        //2.准备关于索引的结构mappings
        XContentBuilder mapping = JsonXContent.contentBuilder()
                .startObject()
                  .startObject("properties")
                     .startObject("name")
                        .field("type","text")
                     .endObject()
                     .startObject("age")
                       .field("type","Integer")
                     .endObject()
                     .startObject("birthday")
                       .field("type","date")
                       .field("format","yyyy-MM-dd")
                     .endObject()
                  .endObject()
                .endObject();
        //3.将settings和mappings 封装到一个request对象
        CreateIndexRequest request = new CreateIndexRequest(index)
                .settings(settings)
                .mapping(type,mapping);
        //通过client对象去连接ES并执行创建索引
        CreateIndexResponse resp = client.indices().create(request, RequestOptions.DEFAULT);

    }

    /**
     * 检查所引是否存在
     * */
    public  void exists() throws IOException {
        //1.准备request对象
        GetIndexRequest request = new GetIndexRequest();
        request.indices(index);
        //2.通过client去操作
        boolean exists = client.indices().exists(request,RequestOptions.DEFAULT);
        //3.输出
    }

    /**
     * 删除所引是否存在
     * */
    public  void delete() throws IOException {
        //1.准备request对象
        DeleteIndexRequest request = new DeleteIndexRequest();
        request.indices();
        //2.通过client去操作
        AcknowledgedResponse delete = client.indices().delete(request, RequestOptions.DEFAULT);
        //3.输出
        System.out.println(delete.isAcknowledged());
    }


}
