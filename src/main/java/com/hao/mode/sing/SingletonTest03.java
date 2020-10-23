package com.hao.mode.sing;

/**
 * 懒汉式第一种
 *
 * @author zrh
 * @version 1.0
 * @date 2020-10-23 16:01
 **/
public class
SingletonTest03 {
    public static void main(String[] args) {
        Singleton03 singleton02 = Singleton03.getInstance();
        Singleton03 singleton01 = Singleton03.getInstance();
        //true 内存地址相同
        System.out.println(singleton01 == singleton02);
    }
}
/**
 * 线程不安全的
 * 优点：起来懒加载的效果，只能在单线程中使用，
 * 在多线程下，有线程不安全，
 * 结论：在实际开发中，不要使用这种方式，
 * */
class Singleton03{
    private static Singleton03 instance;
    private Singleton03(){}
    public static Singleton03 getInstance(){
        if (instance == null){
            instance = new Singleton03();
        }
        return instance;
    }
}
