package com.hao.domain;

import lombok.Data;

import java.util.List;

/**
 * 停车请求类
 *
 * @author zrh
 * @version 1.0
 * @date 2020-07-21 18:05
 **/
@Data
public class ParkIssueRequest {

    private Integer tokenOper;


    private boolean alreadyIn;

    //凭证编号
    private String tokenId;

    /**
     * 车牌号
     */
    private String serialNo;

    private String staffNo;

    private String staffName;

    private String telphoneNo;

    /**
     * 组织
     */
    private String orginazitionId;

    /**
     * 卡的类型
     * free=1 免费
     */
    private String tcm;

    /**
     * =12 其他
     */
    private Integer payType;

    /**
     * 余额 0 免费
     */
    private Integer accountBalance;

    private String beginDate;

    private String  endDate;

    /**
     * Collection of string 开通设备
     */
    private List<String> authDevice;

    /**
     * 标识
     */
    private String token;

    /**
     * 凭证类型  车牌=0 卡片=1 ETC=2
     */
    private Integer tokenType;

    /**
     * 使用模式（写卡模式=0下载模式=1）
     */
    private Integer useModel;

    /**
     * 车牌
     */
    private String plate;

    /**
     * 操作员编号
     */
    private String operNo;

    /**
     * 操作员名称
     */
    private String operName;

    /**
     * 登记时间
     */
    private String redate;

    /**
     * 项目编号
     */
    private String gid;

    /**
     * 项目编号集合
     */
    private List<String> projectGidS;

    /**
     * 操作编号  填 0
     */
    private Integer id;

    /**
     * 是否合法
     * */
    private Boolean isLegal;


}
