package com.hao.mode.template.instance;

import jdk.nashorn.internal.codegen.types.ArrayType;

import java.util.ArrayList;

/**
 * @author zrh
 * @version 1.0
 * @date 2020-11-24 13:02
 **/
public class Client {
    public static void main(String[] args) {
        Comparable<String> comparable = (Comparable<String>) new ArrayList<String>();
        LoginModel lm = new LoginModel();
        lm.setLoginId("admin");
        lm.setPwd("123456");
        //判断是用户还是工作人员
        LoginTemplate lt = new WorkerLogin();
        LoginTemplate normal = new NormalLogin();
        //进行登入测试
        boolean flag = lt.login(lm);
        System.out.println("是否可以登录工作平台" + flag);
        boolean flag2 = normal.login(lm);
        System.out.println("是否可以登录普通用户" + flag2);

    }
}
