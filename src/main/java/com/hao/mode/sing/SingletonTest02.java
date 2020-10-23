package com.hao.mode.sing;

/**
 * 单例模式饿汉式第二种写法
 *
 * @author zrh
 * @version 1.0
 * @date 2020-10-23 15:53
 **/
public class SingletonTest02 {
    public static void main(String[] args) {
        Singleton02 singleton02 = Singleton02.instance;
        Singleton02 singleton01 = Singleton02.instance;
        //true 内存地址相同
        System.out.println(singleton01 == singleton02);

    }
}

/**
 * 饿汉式（静态代码块）
 * <p>
 * 优点：这种写法比较简单，避免现场同步问题
 * 缺点：在类装载的时候就完成实例化，没有达到 Lazy loading的效果
 * 结论：这种单例模式可用，可能造成内存浪费
 */
class Singleton02 {
    //构造器私有化
    private Singleton02() {
    }

    //本类内部创建对象实例化
    public final static Singleton02 instance;

    static {
        instance = new Singleton02();
    }

    //3.提供一个共有的静态方法，返回实例对象
    public static Singleton02 getInstance() {
        return instance;
    }


}
