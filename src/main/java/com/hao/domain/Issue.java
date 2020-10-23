package com.hao.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 车牌发行
 *
 * @author zrh
 * @version 1.0
 * @date 2020-07-21 14:32
 **/
@Data
public class Issue {

    /**
     * 车牌号
     */
    private String serialNo;

    /**
     * 新车牌号 跟环车牌使用
     */
    private String newToken;

    /**
     * 0:车牌
     */
    Integer tokenType;

    /**
     * Ic号
     */
    String icNumber;
    /**
     * Id号
     */
    String idNumber;
    /**
     * 办卡押金
     */
    BigDecimal deposit;
    /**
     * 输入/录入
     */
    boolean isWrite;
    /**
     * 人员编号
     */
    String staffNo;
    /**
     * 人员姓名
     */
    String staffName;
    /**
     * 电话号码
     */
    String telphoneNo;
    /**
     * 住址
     */
    String address;

    /**
     * 文档有错误单词 Orginazition *
     * 组织编号
     */
    String organization;
    /**
     * 操作员编号 *
     */
    String operNo;
    /**
     * 操作员名称 *
     */
    String operName;

    /**
     * 登记时间
     */
    Data redate;
    /**
     * 项目编号 *
     */
    String gid;

    /**
     * 可为空*
     */
    String projectGids;
    /**
     * 项目编号*
     */
    Integer id;

    /**
     * 一个类
     */
    private ParkIssueRequest parkIssue;

    /**
     * 标识号*
     */
    String rId;

    /**
     * 是否合法
     */
    boolean isLegal;

}
