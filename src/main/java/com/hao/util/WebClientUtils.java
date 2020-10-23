package com.hao.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * 工具
 *
 * @author zrh
 * @version 1.0
 * @date 2020-07-24 11:58 http://vddkpw.natappfree.cc/api/
 **/
public class WebClientUtils {
    private static final String HOST = "http://115.238.97.212:60009/api/";

    //  private static final String HOST = "http://local.yunzhiyuan100.com:11228/api/";
    public static String postHttp(String url, Map<String, Object> paramMap) throws Exception {
        String json = JSONObject.toJSONString(paramMap);
        System.out.println(json);
        Mono<String> resp = WebClient.create().post()
                .uri(HOST + url)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(json))
                .retrieve().bodyToMono(String.class);
        return resp.block();
    }

    public static String postJsonHttp(String url, String json) throws Exception {
        String jsonStr = JSON.toJSONString(json);
        Mono<String> resp = WebClient.create().post()
                .uri(HOST + url)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(jsonStr))
                .retrieve().bodyToMono(String.class);
        return resp.block();
    }

    public static String getHttp(String url) throws Exception {
        Mono<String> resp = WebClient.create().get()
                .uri(HOST + url)
                .retrieve()
                .bodyToMono(String.class);
        return resp.block();
    }

    public static String putHttp(String url, Map<String, Object> paramMap) throws Exception {
        String json = JSONObject.toJSONString(paramMap);
        Mono<String> resp = WebClient.create().put()
                .uri(HOST + url)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(json))
                .retrieve().bodyToMono(String.class);
        return resp.block();
    }

    public static String deleteHttp(String url) throws Exception {
        Mono<String> resp = WebClient.create()
                .delete()
                .uri(HOST + url)
                .retrieve()
                .bodyToMono(String.class);

        return resp.block();

    }


    public static void main(String[] args) {
       /* Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("PageSize", 1000);
        paramMap.put("CurrentPage", 1);
        paramMap.put("OrderBy", "id");
        paramMap.put("OrderType", true);
        paramMap.put("TotalCount", 0);
        String json = JSONObject.toJSONString(paramMap);
        String url = "http://192.168.1.62:60009/api/InVehicle/GetByCustom";
        Mono<String> resp = WebClient.create().post()
                .uri(url)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(json))
                .retrieve().bodyToMono(String.class);
        System.out.println(resp.block());*/
    }
}
