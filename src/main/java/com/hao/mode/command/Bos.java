package com.hao.mode.command;

/**
 * @author zrh
 * @version 1.0
 * @date 2020-11-28 17:32
 **/
public class Bos {

    /**
     * 开机对象
     * */
    private  Command openCommand;

    /**
     * 设置开机命令对象
     * */
    public void setOpenCommand(Command openCommand) {
        this.openCommand = openCommand;
    }

    public void openButtonPressed(){
        openCommand.execute();
    }

}
