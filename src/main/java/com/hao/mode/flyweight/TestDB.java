package com.hao.mode.flyweight;

import java.util.ArrayDeque;
import java.util.Collection;

/**
 * 模拟数据库
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-19 09:50
 **/
public class TestDB {

    /**
     * 用来存放授权数据的值
     * */
    public static Collection<String> colDb = new ArrayDeque<>();
    static {
        colDb.add("张三,人员列表,查看");
        colDb.add("李四,人员列表,查看");
        colDb.add("李四,薪资数据,查看");
        colDb.add("李四,薪资数据,修改");
        for (int i = 0;i < 3; i++){
            colDb.add("张三"+i+",人员列表,查看");
        }

    }
}
