package com.hao.mode.command.menu;

/**
 * 绿豆排骨煲
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-28 18:26
 **/
public class ChopCommand implements Command {

    /**
     * 持有具体的厨师对象
     */
    private CookApi cookApi = null;

    /**
     * 点菜桌号
     */
    private int tableNum;

    public ChopCommand(int tableNum) {
        this.tableNum = tableNum;
    }

    @Override
    public int getTableNum() {
        return tableNum;
    }

    @Override
    public void execute() {
        this.cookApi.cook(tableNum, "绿豆排骨");
    }

    @Override
    public void setCookApi(CookApi cookApi) {
        this.cookApi = cookApi;

    }

}
