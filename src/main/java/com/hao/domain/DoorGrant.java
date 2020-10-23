package com.hao.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 设备
 *
 * @author zrh
 * @version 1.0
 * @date 2020-07-22 14:39
 **/
@Data
public class DoorGrant implements Serializable {

    private Integer id;

    private String tokenId;

    private String collectCode;

    private Integer devNo;

    private String devName;

    private String gid;

    private String rid;
}
