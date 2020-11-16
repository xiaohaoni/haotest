package com.hao.demo;

import lombok.Data;

/**
 * 狗类
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-13 10:10
 **/
@Data
public class Dog {
    private Long id;
    private String name;
    private String memo;

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", memo='" + memo + '\'' +
                '}';
    }
}
