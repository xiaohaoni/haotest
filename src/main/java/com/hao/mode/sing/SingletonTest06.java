package com.hao.mode.sing;

/**
 * 静态内部类
 *
 * @author zrh
 * @version 1.0
 * @date 2020-10-23 16:26
 **/
public class SingletonTest06 {
    public static void main(String[] args) {
        Singleton06 singleton02 = Singleton06.getInstance();
        Singleton06 singleton01 = Singleton06.getInstance();
        //true 内存地址相同
        System.out.println(singleton01 == singleton02);
    }
}

/**
 *
 * 优点：起来懒加载的效果
 *这种方式采用了类装载的机制来保证初始化实例只有一个线程，
 * 静态内部类方式在在Singleton06类被装载时并不会立即实例化，
 * 而是需要实例化时调用getInstance（）方法，才会装载SingletonInstance类，从而完成实例化
 *推荐使用
 * */
class Singleton06{
    /**
     * 加入了一个volatile
     * Java语言提供了一种稍弱的同步机制，即volatile变量，用来确保将变量的更新操作通知到其他线程。
     * 当把变量声明为volatile类型后，编译器与运行时都会注意到这个变量是共享的，
     * 因此不会将该变量上的操作与其他内存操作一起重排序。volatile变量不会被缓存在寄存器或者对其他处理器不可见的地方，
     * 因此在读取volatile类型的变量时总会返回最新写入的值。
     * */
    private static volatile Singleton06 instance;

    private Singleton06(){}
    //写一个静态内部类，该类中有一个静态属性，singleton
    private static class SingletonInstance{
        private static final Singleton06 SINGLETON_06 = new Singleton06();
    }

    public static Singleton06 getInstance(){

        return SingletonInstance.SINGLETON_06;
    }
}
