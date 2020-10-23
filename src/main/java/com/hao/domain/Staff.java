package com.hao.domain;

import lombok.Data;

import java.util.Date;

/**
 * 人事
 *
 * @author zrh
 * @version 1.0
 * @date 2020-07-21 12:46
 **/
@Data
public class Staff {
    /**
     *编号（数据库自增，新增时可传入空值或0）
     * */
    Integer id;
    /**
     *人员编号
     * */
    String staffNo;
    /**
     *人员姓名
     * */
    String staffName;
    /**
     *性别（0男/1女）
     * */
    Integer sex;
    /**
     *生日
     * */
    Date birthday;
    /**
     *身份证号
     * */
    String idNo;
    /**
     *微信号码
     * */
    String wxNo;
    /**
     *qq号码
     * */
    String qqNo;
    /**
     *邮箱
     * */
    String wmail;

    /**
     * 固定电话
     * */
    String telphoneNo;

    /**
     * 手机号
     * */
    String mobileNo;


    /**
     * 车牌号码
     * */
    String plate;
    /**
     *楼栋号
     * */
    String buildingNo;

    /**
     * 组织机构 关联RId
     * */
    String organizationId;
    /**
     *登记日期
     * */
    Date rollDate;
    /**
     *登记人姓名
     * */
    String operName;
    /**
     *当前状态
     * */
    Integer status;
    /**
     *识别标识
     * */
    Integer identNumber;
    /**
     *备用字段1
     * */
    String reserve1;
    /**
     *备用字段2
     * */
    String reserve2;
    /**
     *备用字段3
     * */
    String reserve3;
    /**
     *备注
     * */
    String remark;
    /**
     *标识号 uuid
     * */
    String rid;
    /**
     *集团标识号
     * */
    String gid;
    /**
     *业主code
     * */
    String ownerCode;

    /**
     * 业主亲属code
     * */
    String ownerParentCode;


}
