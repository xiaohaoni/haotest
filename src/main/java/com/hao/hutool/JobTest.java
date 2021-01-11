package com.hao.hutool;

import cn.hutool.cron.CronUtil;
import cn.hutool.cron.task.Task;
import sun.tools.jar.Main;

/**
 * @author zrh
 * @version 1.0
 * @date 2020-12-26 13:50
 **/
public class JobTest {
    public static void main(String[] args) {
        methodJob();
    }
    public static void methodJob(){
        CronUtil.schedule("0/3 * * * * ? *", new Task() {
            @Override
            public void execute() {
                System.out.println("测试");
            }
        });
        CronUtil.setMatchSecond(true);
        CronUtil.start();
    }

    public void methodJob01(){
        System.out.println("测试");
    }


}
