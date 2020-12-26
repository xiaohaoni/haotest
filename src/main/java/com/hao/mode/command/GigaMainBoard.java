package com.hao.mode.command;

/**
 * 技嘉主板类
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-28 17:26
 **/
public class GigaMainBoard implements MainBoarApi{
    @Override
    public void open() {
        System.out.println("开机");
    }
}
