package com.hao.mode.prototype;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zrh
 * @version 1.0
 * @date 2020-10-26 21:33
 **/
@Data
public class Person implements Serializable,Cloneable {
    private String name;
    private  Integer age;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
