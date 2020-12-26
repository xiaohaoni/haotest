package com.hao.mode.command.menu;

/**
 * 厨师管理类
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-28 20:51
 **/
public class CookManager {
    /**
     * 判断是否需要创建厨师类
     * */
    private static Boolean runFlag = false;

    /**
     * 运行厨师管理
     * */
    public static  void runCook(){
        if (!runFlag){
            System.out.println("厨师开启");
            HotCook cook1 = new HotCook("张三");
            HotCook cook2 = new HotCook("李四");
            HotCook cook3 = new HotCook("王五");
            //启动他们的线程
            Thread t1 = new Thread(cook1);
            t1.start();
            Thread t2 = new Thread(cook2);
            t2.start();
            Thread t3 = new Thread(cook3);
            t3.start();
        }
    }
}
