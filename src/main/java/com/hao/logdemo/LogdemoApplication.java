package com.hao.logdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class LogdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogdemoApplication.class, args);
    }

}
