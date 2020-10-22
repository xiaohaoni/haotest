package com.hao.config.string;

/**
 * 测试
 *
 * @author zrh
 * @version 1.0
 * @date 2020-10-09 15:35
 **/
public class StringIntern1 {
    public static void main(String[] args) {
        String s =new String("a") + new String("b");
        //执行上一段代码是常量池否存在 “ab” 不存在
        /*
        * jdk6:在常量池中创建一个字符串 “ab”
        * jdk7/8:在常量池中没有创建字符串："ab",而是创建一个引用，指向 new String("ab"),将此引用返回
        * */
        String s2 = s.intern();
        System.out.println(s == "ab");// jdk6:true     jdk8:true
        System.out.println(s2 == "ab");//jdk6:false   jdk8:true

    }
}
