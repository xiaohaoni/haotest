package com.hao.config.string;

/**
 * ce
 *
 * @author zrh
 * @version 1.0
 * @date 2020-10-09 10:59
 **/
public class StringNewTest {
    /**
     * new String("ab");创建了几个对象？
     * 两个 一个new 在推中分配
     * 字符串常量池中的对象
     * new String("a")+new String("b") 创建了几个对象
     * 对象1：new StringBuilder()
     * 对象2：new String("a")
     * 对象3:常量池中的 a
     * 对象4：new String("b")
     * 对象5：常量池中的 b
     * 对象6： new String("ab")
     * toString()的调用，在字符串常量池中没有生成ab
     */
    public static void main(String[] args) {
        // String str = new String("ab");
        String str = new String("a") + new String("b");
    }
}
