package com.hao.list;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 测试
 *
 * @author zrh
 * @version 1.0
 * @date 2020-09-23 13:29
 **/
public class TestList {
    public static void main(String[] args) {
        int i = 1;
        boolean result = true;
        while (result) {
            i++;
            System.out.println(i);
            if (i > 4) {
                result = false;
            }

        }
    }
}
