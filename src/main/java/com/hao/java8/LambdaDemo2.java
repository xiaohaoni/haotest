package com.hao.java8;

import groovy.transform.ASTTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 四大核心接口
 *
 * @author zrh
 * @version 1.0
 * @date 2021-03-01 19:22
 * Consumer<T>:消费型接口
 * void accept(T t)
 * Supplier:供给型接口
 * T get();
 * Function<T,R>:函数型接口
 * R apply(T t)
 * <p>
 * Predicate<T>:断言型接口
 * boolean test<T>
 **/
public class LambdaDemo2 {


    //Consumer
    public void test1() {

        happy(1000, (m) -> System.out.println(m));

    }

    public void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }


    /**
     * Supplier
     */
    public void supplierTest() {
        List<Integer> list = getNumList(10, () -> (int) (Math.random() * 100));
        System.out.println(list);

    }

    /**
     * 获取指定个数得集合
     */
    public List<Integer> getNumList(int num, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer n = sup.get();
            list.add(n);
        }
        return list;
    }


    /**
     * Function
     * <p>
     * 函数型接口
     */
    public void functionTest() {
        //去空串
        String newStr = strHandler("\t\t\t 飒飒法发的   杀手阿斯弗", (str) -> str.trim());

    }

    public String strHandler(String str, Function<String, String> fun) {
        return fun.apply(str);
    }


    /**
     * Predicate<T>
     */

    public static void predicateTest() {

        List<String> list = Arrays.asList("aaa", "sdsa", "dsfasf", "gafewrqw", "fdses");
        List<String> filerList = filerStr(list, (s -> s.length() < 5));
        System.out.println(filerList);

    }

    public static List<String> filerStr(List<String> list, Predicate<String> per) {
        List<String> fileList = new ArrayList<>();
        for (String str : list) {
            if (per.test(str)) {
                fileList.add(str);
            }
        }
        return fileList;
    }

    public static void main(String[] args) {
        predicateTest();
    }


}
