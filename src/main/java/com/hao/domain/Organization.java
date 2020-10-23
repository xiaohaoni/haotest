package com.hao.domain;

import lombok.Data;

/**
 * 组织机构
 *
 * @author zrh
 * @version 1.0
 * @date 2020-07-21 13:47
 **/
@Data
public class Organization {

    /**
     *没有上级不填
     * */
    String parentId;

    /**
     *集团标识号
     * */
    String Gid;

    /**
     * 编号 新增传空
     * */
    Integer id;

    /**
     *标识号
     * */
    String Rid;

    /**
     *名称
     * */
    String name;

    /**
     *备注
     * */
    String remark;




}
