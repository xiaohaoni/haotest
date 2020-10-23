package com.hao.domain;

import lombok.Data;

import java.util.Date;

/**
 * 车辆通行记录
 *
 * @author zrh
 * @version 1.0
 * @date 2020-07-22 11:12
 * todo 车辆入场类有重复Rid Gid
 **/
@Data
public class CarCurrentRecord {

    /**
     * 字增子段
     * */
    private Integer id;


    private String tcmName;

    /**
     * 唯一标识 uuid 同一辆车的进出要保持一致
     */
    private String parkingId;


    /**
     * 车牌号码
     * */
    private String regPlate;

    /**
     * 入场识别车牌
     * */
    private String inAutoPlate;

    /**
     * 出场识别车牌
     * */
    private String outAutoPlate;

    /**
     * 出场时间
     * */
    private Date outTime;

    /**
     * 入场时间
     * */
    private Date inTime;

    /**
     * 入场名称
     * */
    private String   inLaneName;


    private String outLaneName;

    /**
     * 创建时间
     * */
    private Date dateCreated;

    /**
     * 最后修改时间
     * */
    private Date lastUpdated;



}
