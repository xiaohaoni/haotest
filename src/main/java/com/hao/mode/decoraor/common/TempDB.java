package com.hao.mode.decoraor.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 在内存中模拟数据库，准备点测试数据，好计算奖金
 *计算规则：
 * 每个人当月业务奖金=当月销售额*3%
 * 每个人累计奖金 = 总的回款额 * 0.1%
 * 团队奖金=团队总销售额 *1%
 * @author zrh
 * @version 1.0
 * @date 2020-11-06 15:54
 **/
public class TempDB {
    private TempDB(){}
    /**
     * 记录每个人的阅读销售额，只用了人员月份没有用
     * */
    public static Map<String,Double> mapMonthSaleMoney = new HashMap<String, Double>();

    static {
        mapMonthSaleMoney.put("张三",10000.0);
        mapMonthSaleMoney.put("李四",20000.0);
        mapMonthSaleMoney.put("王五",30000.0);
        mapMonthSaleMoney.put("赵云",40000.0);
    }
}
