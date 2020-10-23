package com.hao.domain;

import lombok.Data;

/**
 * 设备
 *
 * @author zrh
 * @version 1.0
 * @date 2020-07-25 10:58
 **/
@Data
public class Device {
    Long id;

    /**
     * 设备号（机号）
     */
    Long devNo;

    /**
     * 设备地址
     */
    String devAddr;

    /**
     * 设备通信类别（TCP/485）
     */
    String commType;

    /**
     * 设备名称
     */
    String devName;
    /**
     * 设备类型标识码（详见附表一人脸门禁设备类别） 1 车管系统
     */
    String devTypeCode;
    /**
     * 系列代码
     */
    String collectCode;
    /**
     * 备注
     */
    String remark;
    /**
     * 所属组
     */
    String groupId;
    /**
     * 项目编号项目编号
     */
    String gid;
    /**
     * 唯一标示
     */
    String rid;
}
