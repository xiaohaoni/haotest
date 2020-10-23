package com.hao.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 推送数据
 *
 * @author zrh
 * @version 1.0
 * @date 2020-07-22 10:24
 **/
@Data
public class PushDada implements Serializable {

    private Integer id;

    private String tableName;

    private String rid;

    private Integer operType ;

    private Date operDate;

    private Date gid;


}
