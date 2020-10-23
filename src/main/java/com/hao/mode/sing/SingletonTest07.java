package com.hao.mode.sing;

/**
 * 枚举类型
 *
 * @author zrh
 * @version 1.0
 * @date 2020-10-23 16:37
 **/
public class SingletonTest07 {
    public static void main(String[] args) {
        Singleton07 singleton02 = Singleton07.SINGLETON_07;
        Singleton07 singleton01 = Singleton07.SINGLETON_07;
        //true 内存地址相同
        System.out.println(singleton01 == singleton02);
        singleton01.sakOk();
    }
}
/**
 * 推荐使用
 * 优点：这借助jdk中添加的枚举来实现单例模式，不仅避免多线程同步问题，
 * 而且还可以反正返序列号重新创建的对象
 *
 * */
enum Singleton07{
    SINGLETON_07;//属性
    public void sakOk(){
        System.out.println("ok~");
    }
}
