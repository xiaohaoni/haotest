package com.hao.config.string;

/**
 * 测试
 *
 * @author zrh
 * @version 1.0
 * @date 2020-10-09 15:22
 **/
public class StringIntern {

    public static void main(String[] args) {
        String s = new String("1");
        s.intern();
        String s2 = "1";
        //false
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        //执行上一段代码是常量池否存在 “11” 不存在
        /*  在字符串常量池中，生成一个“11”，
        * jdk6:创建了一个新的对象“11”，也就是有新的地址。
        * jdk7:在常量池中并没有创建 “11”，而是创建一个只想堆空间
        * */
        s3.intern();
        //s4变量记录的地址：使用的时上一行代码执行时在常量池中生成“11”的地址
        String s4 = "11";
        //jdk6 false  jsk7/8  true
        System.out.println(s3 == s4);

    }
}
