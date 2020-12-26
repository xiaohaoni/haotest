package com.hao.mode.command.menu;

/**
 * @author zrh
 * @version 1.0
 * @date 2020-11-28 20:47
 **/
public class Waiter {
    //获取一个宏命令  菜单
    private  MenuCommand menu = new MenuCommand();

    /**
     *
     * 客户点菜*/
    public  void orderDish(Command command){
        System.out.println("开始点菜");
        menu.addCommand(command);
    }

    /**
     * 点菜完毕执行命令
     * */
    public  void orderOver(){
        this.menu.execute();
    }
}
