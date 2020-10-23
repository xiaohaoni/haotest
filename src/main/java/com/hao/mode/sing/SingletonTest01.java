package com.hao.mode.sing;

/**
 * 饿汉式
 *
 * @author zrh
 * @version 1.0
 * @date 2020-10-23 15:44
 **/
public class SingletonTest01 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.instance;


    }
}
/**
 * 饿汉式（静态变量）
 *
 * 优点：这种写法比较简单，避免现场同步问题
 * 缺点：在类装载的时候就完成实例化，没有达到 Lazy loading的效果
 * 结论：这种单例模式可用，可能造成内存浪费
 * */
class Singleton{
    //构造器私有化
    private Singleton(){}
    //本类内部创建对象实例化
    public final static Singleton instance = new Singleton();
    //3.提供一个共有的静态方法，返回实例对象
    public static Singleton getInstance(){
        return instance;
    }


}

