package com.hao.util;

import lombok.Data;

import java.io.Serializable;

/**
 * 富士返回数据
 *
 * @author zrh
 * @version 1.0
 * @date 2020-07-24 14:20
 **/
@Data
public class FuShiRestult implements Serializable {

    private boolean isSucess;

    private boolean isError;

    private Byte code;

    private Integer recordAffected;

    private String describe;

}
