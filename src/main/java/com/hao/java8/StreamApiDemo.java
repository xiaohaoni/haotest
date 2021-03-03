package com.hao.java8;

import com.hao.java8.domain.StaffInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author zrh
 * @version 1.0
 * @date 2021-03-02 09:34
 * stream Api
 * <p>
 * 中间操作
 * <p>
 * 终止操作
 **/
public class StreamApiDemo {

    static List<StaffInfo> list = Arrays.asList(
            new StaffInfo(18, "zs", 6000),
            new StaffInfo(19, "ls", 5000),
            new StaffInfo(64, "ww", 8000),
            new StaffInfo(23, "zl", 1000),
            new StaffInfo(37, "tq", 10000)

    );

//中间操

    /**
     * filter --接收Lambda ,从流中排除某些元素
     * limit--截断流，时器元素部超过给顶数量
     * skip（n） -跳过元素，返回一个内调了前n个元素的里路，若流中元素部组N个，则返回一个空流。与limit(n) 互补
     * distinct-筛选，通过流所生成元素的hashCode和equals()去除重复元素
     */
    //中间操作过滤
    public static void test1() {
        //filter过滤操作，
        Stream<StaffInfo> stream = list.stream()
                //.filter((e) ->e.getAge()>19)
                .filter((e) -> {
                    return e.getAge() > 19;
                }).limit(2);
        //终止操作后才会执行全部内容
        stream.forEach(System.out::println);

    }

    public static void test2() {
        //filter过滤操作，
        Stream<StaffInfo> stream = list.stream()
                //.filter((e) ->e.getAge()>19)
                .filter((e) -> {
                    return e.getAge() > 19;
                })
                //取后两个
                .skip(2);
        //终止操作后才会执行全部内容
        stream.forEach(System.out::println);

    }


    /**
     * 映射
     * map ----接收Lambda,将元素转换成其他形式或提取信息，接收一个函数作为参数，该函数会被应用到每个元素上，并将器映射为一个新的元素
     * flaMap ----接收一个函数作为参数，将流中的每个直都换成另外一个流，然后把所有流连接成一个流
     */

    public static void test3() {
        List<String> listStr = Arrays.asList("aa", "bb", "ee");
        listStr.stream()
                // .map((str)->str.toUpperCase()) 将字母换成大写的
                .map(String::toUpperCase)
                .forEach(System.out::println);
        System.out.println("=====================================");
        //filter过滤操作，
        list.stream()
                //.filter((e) ->e.getAge()>19)
                .map(StaffInfo::getName)
                .forEach(System.out::println);
        System.out.println("=====================================");

        Stream<Stream<Character>> streamStream = listStr.stream()
                //.map(StreamApiDemo::filterCharacter)
                .map((str) -> filterCharacter(str));
        streamStream.forEach(System.out::println);

        System.out.println("=====================================");

        Stream<Character> streamFlaMap1 = listStr.stream()
                //.map(StreamApiDemo::filterCharacter)
                .flatMap((str) -> filterCharacter(str));
        streamFlaMap1.forEach(System.out::println);

    }

    public static Stream<Character> filterCharacter(String str){
        List<Character> list = new ArrayList<>();
        for (Character ch:str.toCharArray()) {
            list.add(ch);
        }
        return list.stream();
    }


    //=========================排序======================================
    /***
     * 排序：
     * sorted()自然排序
     * sorted:定制排序
     * */
    public static void test4(){
        List<String> listStr = Arrays.asList("aaa","dfd","asc");
        listStr.stream().sorted().forEach(System.out::println);
        System.out.println("================================");
        list.stream().sorted((e1,e2)->{
            if (e1.getAge().equals(e2.getAge())){
                return e1.getName().compareTo(e2.getName());
            }else {
                return e1.getAge().compareTo(e2.getAge());
            }
        }).forEach(System.out::println);

    }


    public static void main(String[] args) {
        test4();
    }

}
