package com.hao.mode.sing;

import java.util.ArrayList;
import java.util.List;

/**
 * 单例模式测试
 *
 * @author zrh
 * @version 1.0
 * @date 2020-10-26 10:30
 **/
public class SingletonTestMain {
    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();
        for (int i = 0;i<10;i++){
            Person person = Person.getPersonInstance();
            person.setName("张"+i);
            person.setAge(i);
            people.add(person);
        }
        for (Person person1:people){
            System.out.println(person1);
        }
    }
}
