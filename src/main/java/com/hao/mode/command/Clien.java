package com.hao.mode.command;



/**
 * @author zrh
 * @version 1.0
 * @date 2020-11-28 17:34
 **/
public class Clien {
    public static void main(String[] args) {
        MainBoarApi api = new GigaMainBoard();
        OpenCommand openCommand = new OpenCommand(api);
        Bos box = new Bos();
        box.setOpenCommand(openCommand);
        box.openButtonPressed();


    }
}
