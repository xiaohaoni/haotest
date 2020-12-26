package com.hao.mode.command.menu;

/**
 * @author zrh
 * @version 1.0
 * @date 2020-11-28 20:30
 * 做热菜厨师对象，
 **/
public class HotCook implements CookApi, Runnable {

    String name;

    public HotCook(String name) {
        this.name = name;
    }

    @Override
    public void cook(int tableNum, String name) {
        //随机取每道菜的时间
        int time = (int) (20 * Math.random());
        System.out.println(this.name + "厨师，正在为+" + tableNum + "做" + name + "菜");
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.name + "厨师，正在为+" + tableNum + "做" + name + "菜,已做好，花了" + time + "时间");

    }

    @Override
    public void run() {
        //从队列中获取命令对象
        while (true) {
            Command command = CommandQueue.getOneCommand();
            if (command != null) {
                command.setCookApi(this);
                //执行命令
                command.execute();
            }
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
