package com.hao.mode.command.menu;

import java.util.ArrayList;
import java.util.List;

/**
 * 命令队列
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-28 18:33
 **/
public class CommandQueue {

    /**
     * 用来存命令的队列
     */
    private static List<Command> cmds = new ArrayList<>();

    public synchronized static void addMenu(MenuCommand menu) {
        /**
         * 一个菜单有多个命令
         * */
        for (Command cmd : menu.getCommands()) {
            cmds.add(cmd);
        }
    }

    /**
     * 厨师从命令中获取命令消费
     */
    public static Command getOneCommand() {
        Command command = null;
        if (cmds.size() > 0){
            command = cmds.get(0);
            cmds.remove(0);
        }
        return command;
    }
}
