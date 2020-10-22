package com.hao.config;


import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;


/**
 * 测试
 *
 * @author zrh
 * @version 1.0
 * @date 2020-09-13 20:25
 **/
@Configuration
public class MyMvcConfig extends WebMvcAutoConfiguration {
    public static void main(String[] args) {

    }

    public void test(){

        int i = 0;
        String str = "hello";
        Long lo = 23L;
    }
}
