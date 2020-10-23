package com.hao.domain;

import lombok.Data;

/**
 * 富士
 *
 * @author zrh
 * @version 1.0
 * @date 2020-07-30 11:05
 **/
@Data
public class FsModelResult {

    private Integer id;

    private String errMessage;

    private boolean result;

    private Integer errCode;
}
