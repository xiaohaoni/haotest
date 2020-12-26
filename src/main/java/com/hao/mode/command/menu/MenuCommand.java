package com.hao.mode.command.menu;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author zrh
 * @version 1.0
 * @date 2020-11-28 18:35
 **/
public class MenuCommand implements Command{
    private Collection<Command> commands = new ArrayList<Command>();

    /**
     * 点菜将菜单加入菜单中
     * */
    public void addCommand(Command command){
        commands.add(command);
    }
    public Collection<Command> getCommands() {
        return this.commands;
    }

    @Override
    public void execute() {
        CommandQueue.addMenu(this);

    }

    @Override
    public void setCookApi(CookApi cookApi) {

    }

    @Override
    public int getTableNum() {
        return 0;
    }
}
