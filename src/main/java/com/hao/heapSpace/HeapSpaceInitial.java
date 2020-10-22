package com.hao.heapSpace;

/**
 * @author zrh
 * @version 1.0
 * @date 2020-09-23 19:01
 **/
public class HeapSpaceInitial {

    public static void main(String[] args) {
        long initialMemory = Runtime.getRuntime().totalMemory()/1024/1024;
        long maxMemory = Runtime.getRuntime().maxMemory() /1024/1024;
        System.out.println("-Xms:"+initialMemory);
        System.out.println("-Xmx:"+maxMemory);
    }
}
