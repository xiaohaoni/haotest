package com.hao.jvm;

/**
 * 标量替换
 *
 * @author zrh
 * @version 1.0
 * @date 2020-09-27 11:40
 * -XX:+DoEscapeAnalysis 开启逃逸分析 默认开启
 *  -Xms100m -Xmx100m -XX:+DoEscapeAnalysis  -XX:+PrintGCDetails -XX:-EliminateAllocations 注 是否开启标量替换
 *   -XX:MetaspaceSize=100 方法区的初始值大小  -XX:MaxMetaspaceSize=100 最大的大小
 *  标量替换：将一个聚合量（可以分解）分解成标量（一个无法在分解成更小的数据的数据），
 *  定义：吐过经过逃逸分析，发现一个对象不会被外界访问的话，那么经过JIT优化，就会把这个对象拆解成若干个其中包含若干个成员变量替换
 **/
public class ScalarReplace {
    public static class User{
        public int id;
        public String name;
    }
    public static void alloc(){
        //未发生逃逸
        User user = new User();
        user.id = 2;
        user.name = "浩";
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0;i<10000000;i++ ){
            alloc();
        }
        System.out.println( System.currentTimeMillis() - start);
    }
}
