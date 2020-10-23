package com.hao.demo;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.List;

/**
 * jsondemo
 *
 * @author zrh
 * @version 1.0
 * @date 2020-07-21 17:13
 **/
public class JsonDemo {

    public static void main(String[] args) {

        String phone = "18501234234";

        String hidenPhone = phone.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2");

        System.out.println(hidenPhone);

    }

    public JSONObject newCrean() {
        JSONObject object = new JSONObject();
        //string
        object.put("string", "string");
        //int
        object.put("int", 2);
        //boolean
        object.put("boolean", true);
        //array
        List<Integer> integers = Arrays.asList(1, 2, 3);
        object.put("list", integers);
        //null
        object.put("null", null);
        System.out.println(object);
        return object;
    }


}
