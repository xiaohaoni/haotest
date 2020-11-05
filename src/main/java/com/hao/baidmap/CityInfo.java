package com.hao.baidmap;

import lombok.Data;

/**
 * @author zrh
 * @version 1.0
 * @date 2020-10-29 18:12
 **/
@Data
public class CityInfo {
    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String county;
}
