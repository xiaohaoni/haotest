package com.hao.thread;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author zrh
 * @version 1.0
 * @date 2021-02-26 13:26
 *
 **/
public class ListThreadDemo {
    public static void main(String[] args) {
        List<String> list =  new CopyOnWriteArrayList<>();
        for (int i = 0; i <= 3; i++) {
            //报:ConcurrentModificationException
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i).toString()).start();
        }

    }

    /**
     * 1.故障现象
     * 2.导致原因
     * 3.解决方案
     * 4.优化建议（同样的问题不放第二次）
     * 高并发出现 ConcurrentModificationException
     */
    public void solveListException(){
        //用vector
        List<String> va =new Vector<>();

        //2.Collections集合辅助类
        List<String> list = Collections.synchronizedList(new ArrayList<>());

        //3.
        List<String> copyList = new CopyOnWriteArrayList<>();
        copyList.add("a");

    }
}
