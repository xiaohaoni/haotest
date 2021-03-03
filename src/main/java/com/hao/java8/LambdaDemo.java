package com.hao.java8;


import com.hao.domain.Staff;
import com.hao.java8.domain.StaffInfo;

import java.util.*;
import java.util.function.Consumer;

/**
 * @author zrh
 * @version 1.0
 * @date 2021-02-28 23:02
 **/
public class LambdaDemo {
    /**
     * 匿名内部类
     */
    public void test1() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        };
        TreeSet<Integer> set = new TreeSet(comparator);

    }

    /**
     * 使用java8
     */
    public void lambdaTest1() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> set = new TreeSet(com);
    }

    /**
     * 需求获取gae大于35的员工,或工资大于5000的
     */
    public void test2() {
        List<StaffInfo> list = new ArrayList<>();
        list.stream()
                .filter((e) -> e.getAge() > 35)
                .limit(2);

    }

    /**
     * 无参数 （）->
     * 一个参数，无返回值 （a）->
     */
    public static void noParameters() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        };
        runnable.run();

        Runnable run = () -> System.out.println("hello");
        run.run();
    }

    public static void oneParameters() {
        Consumer<String> con = x -> System.out.println(x);
        con.accept("你好");
    }

    /**
     * 表达式参数列表中数据类型可以不写，可以通过上下文推断类型
     */
    public static void twoParameters() {
        Comparator<Integer> com = (x, y) -> {
            return Integer.compare(x, y);
        };
        Set<Integer> set = new TreeSet<>(com);

    }

    /**
     * 如果接口中只有一个接口，称为函数式接口
     * 运算
     */
    public static Integer calculation(Integer num, MyFun mf) {
        return mf.getValue(num);
    }

    public static Integer calculationUse(Integer num) {
        num = calculation(num, (x) -> x * x);
        System.out.println(num);
        return num;
    }

    //===================================================================
    static List<StaffInfo> staffInfoList = Arrays.asList(
            new StaffInfo(18, "zs", 6000),
            new StaffInfo(19, "ls", 5000),
            new StaffInfo(23, "ww", 8000),
            new StaffInfo(18, "zl", 1000),
            new StaffInfo(34, "tq", 10000)

    );

    /**
     * 排序，年龄相同比名称
     * */
    public static void sortList() {
        Collections.sort(staffInfoList, (e1, e2) -> {
            if (e1.getAge().equals(e2.getAge())) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return -Integer.compare(e1.getAge(), e2.getAge());
            }
        });
        for (StaffInfo info : staffInfoList) {
            System.out.println(info);
        }
    }


    public static void countValue(Integer l1,Integer l2){
        count(l1,l2,(x,y)->x*y);

    }

    public static  void count(Integer l1,Integer l2,CountLambda<Integer,Integer> countLambda){
        System.out.println(countLambda.getValue(l1,l2));
    }


    public static void main(String[] args) {
        countValue(4,4);

    }

}
