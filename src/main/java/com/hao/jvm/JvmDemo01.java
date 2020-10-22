package com.hao.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * jvm测试
 *
 * @author zrh
 * @version 1.0
 * @date 2020-09-26 20:06
 * -Xms9m -Xmx9m -XX:+PrintGCDetails
 * -XX:HandlePromotionFailure :空间分配担保
 * 尽量避免大对象的创建
 **/
public class JvmDemo01 {
    public static void main(String[] args) {
        byte[] b = new byte[1024 * 1024 * 20];
    }

    /**
     * -Xms9m -Xmx9m -XX:+PrintGCDetails
     */
    public void oomTest() {
        int i = 1;
        try {
            List<String> list = new ArrayList<>();
            String str = "hello";
            while (true) {
                list.add(str);
                str = str + str;
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("经过了" + i + "次");
        }
    }

    /**
     * -Xms60m -Xmx60m -XX:NewRatio=2 -XX:SurvivorRatio=8-XX:+PrintGCDetails
     */
    public void survivorTest() {
        byte[] b = new byte[1024 * 1024 * 2];
    }

    /**
     * -XX:UseTLAB 设置是否开启TLAB
     * */
    public void TLABTest(){

    }
}
