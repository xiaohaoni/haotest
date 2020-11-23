package com.hao.esClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 操作文档
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-23 14:34
 **/
public class OperatingTest {
    ObjectMapper mapper = new ObjectMapper();
    RestHighLevelClient client = EsClient.getClient();
    //索引
    String index = "person";
    /**
     * 类型
     * */
    String type = "man";

    /**
     *添加文档
     * */
    public void createDoc() throws IOException {
        //准备一个json数据
        Person person = new Person(1,"张三",23,new Date());
        String json = mapper.writeValueAsString(person);
        //准备一个request 对象
        IndexRequest request = new IndexRequest(index,type,person.getId().toString());
        request.source(json, XContentType.JSON);
        //通过client对象指向添加
        IndexResponse response = client.index(request, RequestOptions.DEFAULT);

        System.out.println(response.getResult().toString());
    }

    /**
     * 修改文档
     * */
    public void updateDoc() throws IOException {
        //创建一个Map,指定需要修改的内容
        Map<String ,Object> doc = new HashMap<>();
        doc.put("name","张大大");
        String docId = "1";
        //准备一个request 对象
        UpdateRequest request = new UpdateRequest(index,type,docId);
        request.doc(doc);
        //通过client对象修改
        UpdateResponse response = client.update(request, RequestOptions.DEFAULT);

        System.out.println(response.getResult().toString());
    }

    /**
     * 删除文档
     * */
    public void deleteDoc() throws IOException {
        //封装request对象
        DeleteRequest request = new DeleteRequest(index,type,"1");
        //通过client对象修改
        DeleteResponse response = client.delete(request, RequestOptions.DEFAULT);
        System.out.println(response.getResult().toString());
    }

    /**
     *批量操作
     * */
    public void bulkCreateDoc() throws IOException {
        //准备多个个json数据
        Person person = new Person(1,"张三",23,new Date());
        Person person1 = new Person(2,"张三1",24,new Date());
        Person person2 = new Person(3,"张三2",25,new Date());
        Person person3 = new Person(4,"张三3",26,new Date());
        String json = mapper.writeValueAsString(person);
        String json1 = mapper.writeValueAsString(person1);
        String json2 = mapper.writeValueAsString(person2);
        String json3 = mapper.writeValueAsString(person3);
        //准备一个request 对象
        BulkRequest request = new BulkRequest();
        request.add(new IndexRequest( index,type, person.getId().toString()).source(json,XContentType.JSON));
        request.add(new IndexRequest( index,type, person1.getId().toString()).source(json1,XContentType.JSON));
        request.add(new IndexRequest( index,type, person2.getId().toString()).source(json2,XContentType.JSON));
        request.add(new IndexRequest( index,type, person3.getId().toString()).source(json3,XContentType.JSON));
        //通过client对象指向添加
        BulkResponse response = client.bulk(request, RequestOptions.DEFAULT);
    }

    /**
     * 批量删除
     * */
    public void bulkDeleteDoc() throws IOException {

        BulkRequest request = new BulkRequest();
        request.add(new DeleteRequest(index,type,"1"));
        request.add(new DeleteRequest(index,type,"2"));
        request.add(new DeleteRequest(index,type,"3"));

        //执行client执行
        BulkResponse resp = client.bulk(request,RequestOptions.DEFAULT);



    }

}
