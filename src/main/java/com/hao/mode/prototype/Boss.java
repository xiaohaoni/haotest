package com.hao.mode.prototype;

import lombok.Data;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.security.core.parameters.P;

import java.io.*;

/**
 * @author zrh
 * @version 1.0
 * @date 2020-10-26 21:32
 * 原型模式
 **/
@Data
public class Boss implements Serializable, Cloneable {

    private String name;
    private Integer age;
    private String alias;
    private Person person;

    public Boss() {
        super();
    }

    /**
     *重写clone方法
     * 这个为浅克隆，不会重新分配内存地址
     */
/*
    @Override
    protected Boss clone() throws CloneNotSupportedException {
        Boss boss = (Boss) super.clone();
        return boss;
    }
*/

    /**
     * 深拷贝,直接拷贝对象，且分配内存
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object deep = null;
        deep = super.clone();
        Boss boss = (Boss) deep;
        boss.person = (Person) person.clone();
        return deep;
    }

    /**
     * 用流来进行拷贝
     */
    public Object deepClone() throws Exception{
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            //反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            Boss bossObj = (Boss) ois.readObject();
            return bossObj;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            bos.close();
            oos.close();
            bis.close();
            ois.close();

        }
        return null;
    }


}
