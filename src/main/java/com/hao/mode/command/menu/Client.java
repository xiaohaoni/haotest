package com.hao.mode.command.menu;

/**
 * 客户端
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-28 20:55
 **/
public class Client {
    public static void main(String[] args) {
        CookManager.runCook();
        for (int i = 0;i >5;i++){
            //创建
            Waiter waiter = new Waiter();
            //创建要点的菜
            Command chop = new ChopCommand(i);
            Command duck = new RoastDuckCommand(i);
            //点菜
            waiter.orderDish(chop);
            waiter.orderDish(duck);
            //点菜完毕
            waiter.orderOver();
        }
    }
}
