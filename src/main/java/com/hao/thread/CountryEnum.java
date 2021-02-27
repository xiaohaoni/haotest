package com.hao.thread;

import lombok.Getter;

/**
 * 枚举
 *
 * @author zrh
 * @version 1.0
 * @date 2021-02-27 10:41
 **/
public enum CountryEnum {
    /*
    * 国家
    * */
    ONE(1, "齐"),
    TWO(2, "楚"),
    THREE(3, "燕"),
    FOUR(4, "赵");
    @Getter
    private final Integer key;
    @Getter
    private final String value;

    CountryEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public static CountryEnum forEachCountryEnum(int key) {
        CountryEnum[] values = CountryEnum.values();
        for (CountryEnum element : values) {
            if (element.key == key) {
                return element;
            }
        }
        return null;
    }
}
