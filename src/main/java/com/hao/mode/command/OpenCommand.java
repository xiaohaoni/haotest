package com.hao.mode.command;

/**
 * @author zrh
 * @version 1.0
 * @date 2020-11-28 17:28
 **/
public class OpenCommand implements Command{

    /**
     * 持有真正命令的介绍这，主板对象
     *
     * */
    private MainBoarApi mainBoarApi = null;

    public OpenCommand(MainBoarApi mainBoarApi) {
        this.mainBoarApi = mainBoarApi;
    }

    /**
     * 构造方法
     * */

    @Override
    public void execute() {
        this.mainBoarApi.open();
    }
}
