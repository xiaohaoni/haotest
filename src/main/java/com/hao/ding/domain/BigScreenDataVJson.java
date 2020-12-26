package com.hao.ding.domain;


import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 获取创建填表数据
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-26 10:09
 **/
@Data
public class BigScreenDataVJson {

    Date createTime;

    String formInstanceId;

    List<GetTableValueJson> forms;


}
