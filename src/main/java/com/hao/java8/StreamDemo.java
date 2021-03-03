package com.hao.java8;

import com.hao.java8.domain.StaffInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author zrh
 * @version 1.0
 * @date 2021-03-02 09:14
 **/
public class StreamDemo {

    public static void test1(){
        //1.可以通过Collection系列集合提供的stream流和parallelStream
        List<String> list = new ArrayList<>();

        Stream<String> stream = list.stream();

        //2.通过Arrays中的静态方法stream（）获取数据流
        StaffInfo[] infos = new StaffInfo[10];
        Stream<StaffInfo> stream1 =  Arrays.stream(infos);


        //3.通过stream类中的静态方法
        Stream<String> stream2= Stream.of("1","3","23");

        //4.创建无线流
        Stream<Integer> stream3 = Stream.iterate(0,(x)->x+2);
         stream3.limit(10).forEach(System.out::println);

        //生成
        //Stream.generate(()->Math.random()).limit(5).forEach(System.out::println);
    }

    public static void main(String[] args) {
        test1();
    }
}
