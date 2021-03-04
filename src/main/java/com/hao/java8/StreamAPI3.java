package com.hao.java8;

import com.hao.java8.domain.StaffInfo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 终止操作
 *
 * @author zrh
 * @version 1.0
 * @date 2021-03-02 13:07
 **/
public class StreamAPI3 {


    static List<StaffInfo> list = Arrays.asList(
            new StaffInfo(18, "zs", 6000, StaffInfo.Status.FREE),
            new StaffInfo(19, "ls", 5000, StaffInfo.Status.VOCATION),
            new StaffInfo(64, "ww", 8000, StaffInfo.Status.FREE),
            new StaffInfo(23, "zl", 1000, StaffInfo.Status.FREE),
            new StaffInfo(37, "tq", 10000, StaffInfo.Status.FREE)

    );


    /**
     * 查找与匹配
     * allMatch --检查是否匹配所有元素
     * anyMatch--检查是否至少匹配一个元素
     * noneMatch -- 检查是否没有匹配所有元素
     * findFirst -返回第一个元素
     * findAny --返回当前流中的任意一个元素
     * count --返回流中元素的总个数
     * max--返回流中的最大值
     * min--返回流中的最小值
     */

    public static void test2() {
        Long count = list.stream().count();
        System.out.println(count);

        Optional<StaffInfo> op1 = list.stream().max((e1, e2) -> Integer.compare(e1.getWage(), e2.getWage()));
        System.out.println(op1.get());
        //返回第一个
        Optional<StaffInfo> first = list.stream().min((e1, e2) -> Integer.compare(e1.getWage(), e2.getWage()));
        System.out.println(first.get());
        //提取最高工资
        Optional<Integer> first1 = list.stream().map(StaffInfo::getWage).max(Integer::compare);
    }

    public static void test1() {
        //是否全是忙录的
        boolean b1 = list.stream()
                .allMatch((e) -> e.getStatus().equals(StaffInfo.Status.BUSY));
        System.out.println(b1);
        //是否有忙碌的
        boolean b2 = list.stream()
                .anyMatch((e) -> e.getStatus().equals(StaffInfo.Status.BUSY));
        System.out.println(b2);
        //没有一个符合的就返回true
        boolean b3 = list.stream()
                .noneMatch((e) -> e.getStatus().equals(StaffInfo.Status.BUSY));
        System.out.println(b3);

        //返回第一个
        Optional<StaffInfo> first = list.stream()
                .sorted((e1, e2) -> Integer.compare(e1.getWage(), e2.getWage()))
                .findFirst();
        System.out.println(first);

        // 任意一个元素
        Optional<StaffInfo> findAny = list.stream()
                .filter((e) -> e.getStatus().equals(StaffInfo.Status.FREE))
                .findAny();
        System.out.println(findAny);


    }
//====================================规约与收集==========================================
    /**
     * 规约
     * reduce
     */
    public void test3() {

        List<Integer> listInt = Arrays.asList(1, 2, 3, 4, 5, 3, 4, 6);
        //计算总和
        //reduce(0, Integer::sum);
        Integer sum = listInt.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum);
    }

    /**
     * 收集
     * 收集工具：collects
     * */
    public  void test4(){
        List<String> nameList = list.stream().map(StaffInfo::getName).collect(Collectors.toList());
    }

    public static void main(String[] args) {

        test1();
    }

}
