package com.hao.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.kevinsawicki.http.HttpRequest;

import java.util.Map;

/**
 * 测试
 *
 * @author zrh
 * @version 1.0
 * @date 2020-07-21 09:45
 **/
public class HttpDemo01 {
    public static final String HEADER_BEARER = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxNTM3MTMzNjcxMyIsImF1dGgiOiJST0xFX1JFSk1HSzhTX0ZFTkdRSVBDIiwiZXhwIjoxNTk1NTU4MDIzLCJpc3MiOiJ7XCJjYW1wdXNJZFwiOjcsXCJzY2hvb2xJZFwiOjEsXCJzdGFmZklkXCI6NTY3LFwidXNlcklkXCI6NDU3fSJ9.mAtCYQsSNiOLrh5Fuaeq5-pmy5lKTLa4AIy3s8XXuoX3kSGKMrE72fBCrzUf_5iI7DnFe4l07Q_veJfBSvg8oA";

    public static final String HTTPS_TYPE = "https://";
    public static final String HTTP_TYPE = "http://";
    public static final String IP = "192.168.1.62:60009/";



    public static String getHttp(String url, String bearer, Map<String, Object> paramMap) {

        String bodyStr = null;
        try {
            HttpRequest httpRequest = HttpRequest.get(HTTP_TYPE + IP + url, paramMap, true)
                    .contentType("application/json", "UTF-8")
                    .acceptCharset("UTF-8")
                    .acceptEncoding("UTF-8")
                    .acceptJson()
                    .trustAllCerts()
                    .trustAllHosts();

            bodyStr = httpRequest.body();
        } catch (HttpRequest.HttpRequestException e) {
            System.out.println("错误");
        }

        return bodyStr;
    }
    public static void main(String[] args) throws Exception {
        String url = "http://192.168.1.62:60009/api/IssueParkView/GetByFunc";
        //String url = "http://192.168.1.62:60009/api/IssueParkView/GetByFunc";
        HttpRequest httpRequest = HttpRequest.post(url)
                .header("Content-Type", "application/json")
                .send(JSON.toJSONString("TokenId = '粤BDQ112'"));
        //.contentLength(0);
        //httpRequest.getConnection().setDoOutput(true);

        String body = httpRequest.body();
        System.out.println(body);

    }

    public static String postHttp(String url, String bearer, Map<String, Object> paramMap) {
        String json = JSONObject.toJSONString(paramMap);
        HttpRequest httpRequest = HttpRequest.post( url, true)
                .contentType("application/json", "UTF-8")
                .acceptCharset("UTF-8")
                .acceptEncoding("UTF-8")
//                .acceptJson()
                .trustAllCerts()
                .trustAllHosts()
                .contentLength(0);
        httpRequest.getConnection().setDoOutput(true);

        String body = httpRequest.body();
        System.out.println(body);
        return body;
    }

}
