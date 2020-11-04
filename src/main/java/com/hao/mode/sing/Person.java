package com.hao.mode.sing;

/**
 * 人
 *
 * @author zrh
 * @version 1.0
 * @date 2020-10-26 10:30
 **/
public class Person {

    private static volatile Person instance;
    private Person(){}
    public static Person getPersonInstance(){
        if (instance == null){
            synchronized (Singleton05.class){
                if (instance == null){
                    instance = new Person();
                }
            }

        }
        return instance;
    }
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
