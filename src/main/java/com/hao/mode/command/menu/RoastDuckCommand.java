package com.hao.mode.command.menu;

/**
 * 烤鸭
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-28 18:31
 **/
public class RoastDuckCommand implements Command{
    /**
     * 持有具体的厨师对象
     */
    private CookApi cookApi = null;

    /**
     * 点菜桌号
     */
    private int tableNum;

    public RoastDuckCommand(int tableNum) {
        this.tableNum = tableNum;
    }

    @Override
    public int getTableNum() {
        return tableNum;
    }

    @Override
    public void execute() {
        this.cookApi.cook(tableNum, "北京烤鸭");
    }

    @Override
    public void setCookApi(CookApi cookApi) {
        this.cookApi = cookApi;

    }
}
