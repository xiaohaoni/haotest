package com.hao.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zrh
 * @version 1.0
 * @date 2021-01-27 11:40
 **/
public class JsonDemo {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        User user = new User(1,"祝");
        User user1 = new User(2,"祝");
        User user2= new User(3,"祝");
        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        String json = JSON.toJSONString(userList);
        System.out.println("json"+JSONObject.parseObject(String.valueOf(userList)));
       // System.out.println("json"+JSONObject.parseObject(json));

    }
}
@Data
class User{
    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    Integer id;

    String name;
}