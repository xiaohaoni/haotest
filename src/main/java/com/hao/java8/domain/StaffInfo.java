package com.hao.java8.domain;

import lombok.Data;

/**
 * @author zrh
 * @version 1.0
 * @date 2021-02-28 23:12
 **/
@Data
public class StaffInfo {
    Integer age;
    String name;
    Integer wage;
    Status status;


    public StaffInfo() {
    }

    public StaffInfo(Integer age, String name, Integer wage) {
        this.age = age;
        this.name = name;
        this.wage = wage;
    }

    public StaffInfo(Integer age, String name, Integer wage, Status status) {
        this.age = age;
        this.name = name;
        this.wage = wage;
        this.status = status;
    }

    @Override
    public String toString() {
        return "StaffInfo{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", wage=" + wage +
                ", status=" + status +
                '}';
    }

    /**
     *
     */
    public enum Status{
        FREE,
        BUSY,
        VOCATION;
    }
}
