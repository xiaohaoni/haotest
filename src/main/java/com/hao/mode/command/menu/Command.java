package com.hao.mode.command.menu;

/**
 * 命令接口，声明执行行的操作
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-28 18:20
 **/
public interface Command {
    /**
     * 命令执行相应的操作
     * */
    public void execute();

    /**设置命令的接收者
     * */
    public void  setCookApi(CookApi cookApi);

    /**
     * 返回请求的桌号
     * */
    public int getTableNum();
}
