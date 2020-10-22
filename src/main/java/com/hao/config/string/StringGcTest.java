package com.hao.config.string;

/**
 * StringGC
 * -Xms15m -Xmx15m -XX:+PrintStringTableStatistics-XX:+PrintGCDetails
 * @author zrh
 * @version 1.0
 * @date 2020-10-09 17:13
 **/
public class StringGcTest {
    public static void main(String[] args) {
        for (int i = 0;i < 1000 ; i ++){
            String.valueOf(i).intern();
        }
    }
}
