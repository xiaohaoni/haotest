package com.hao.mode.decoraor.modeAchieve;

/**
 * @author zrh
 * @version 1.0
 * @date 2020-11-13 17:27
 **/
public class Client {
    public static void main(String[] args) {
        //先创建计算基本奖金的类，这也是被装饰的对象
        Component c1 = new ConcreteComponent();
        //然后对计算的基本奖金进行装饰，这里要组合各个装饰
        //说明，各个装饰着之间最好事不要有先后顺序的限制
        ///也就是先装饰谁最后装饰谁都应该一样的
        //先组合普通业务人员的奖金计算
        Decorator d2 = new SumPrizeDecorator(c1);
        Decorator d1 = new MothPrizeDecorator(d2);

        double zs = d1.calcPrize("张三", null, null);

        System.out.println("===张三应得奖金===" + zs);
        double ls = d1.calcPrize("李四", null, null);
        System.out.println("===李四应得奖金===" + ls);
        //如果是业务经理,还需要一个计算团队的奖金计算
        Decorator d3 = new GroupPrizeDecorator(d1);
        double ww = d3.calcPrize("王五", null, null);
        System.out.println("===王五应得奖金===" + ww);

    }
}
