package com.hao.config.string;

/**
 * 测试
 *
 * @author zrh
 * @version 1.0
 * @date 2020-10-09 15:58
 * 结论：对应程序中大量存在字符串，尤其其中存在大量的相同的字符串，使用intern可以省略空间
 **/
public class StringIntern2 {
    public static void main(String[] args) {
        //会在长量池生成 ab s1 地址指向的是 堆空间的地址
        // String s1 = new String("ab");
        //不会在常量池中生成 ab
        String s1 = new String("a") + new String("b");
        s1.intern();
        //指向常量池
        String s2 = "ab";
        System.out.println(s1 == s2);// jdk6:true     jdk8:true
        StringBuilder stringBuilder = new StringBuilder();
        StringBuffer stringBuffer = new StringBuffer();
    }
}
