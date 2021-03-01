package com.hao.java8;

import com.hao.java8.domain.StaffInfo;

import java.util.Comparator;
import java.util.function.*;

/**
 * 方法引用
 *
 * @author zrh
 * @version 1.0
 * @date 2021-03-01 22:45
 **/
public class TestMethodPre {

    /**
     * 数组引用
     */
    public static void test5(){
        Function<Integer,String[]> function = (x)->new String[x];
        String[] apply = function.apply(10);

        Function<Integer,String[]> fun = String[]::new;
        fun.apply(10);



    }

    /**
     * 构造器引用
     *
     */
    public static void test4(){
        Supplier<StaffInfo> sub = ()->new StaffInfo();

        //构造器引用
        Supplier<StaffInfo> supplier = StaffInfo::new;
        System.out.println(supplier.get());
    }


    /**
     * 类::实例方法名
     */
    public static void test3(){
        BiPredicate<String,String> biConsumer =(x,y)->x.equals(y);
        BiPredicate<String,String> bi = String::equals;
    }

    /**
     * 类静态方法名
     */
    public static  void test2(){
        Comparator<Integer> com = (x,y)->Integer.compare(x,y);
        System.out.println(com.compare(1,2));

        Comparator<Integer> comparator = Integer::compare;

    }
    /**
     * 对象实例方法引用
     * 对象::实例方法名
     */
    public static void test1(){
        StaffInfo info = new StaffInfo();
        Supplier<String> sup = ()->info.getName();
        System.out.println(sup.get());

        Supplier<String> supplier = info::getName;
        System.out.println(supplier.get());
    }
}
