package com.hao.mode.sing;

/**
 * 懒汉式第四种写法双重检查
 *
 * @author zrh
 * @version 1.0
 * @date 2020-10-23 16:14
 **/
public class SingletonTest05 {
    public static void main(String[] args) {
        Singleton05 singleton02 = Singleton05.getInstance();
        Singleton05 singleton01 = Singleton05.getInstance();
        //true 内存地址相同
        System.out.println(singleton01 == singleton02);
    }
}

/**
 *
 * 优点：起来懒加载的效果
 * 双重检查
 *推荐使用
 *
 * */
class Singleton05{
    /**
     * 加入了一个volatile
     * Java语言提供了一种稍弱的同步机制，即volatile变量，用来确保将变量的更新操作通知到其他线程。
     * 当把变量声明为volatile类型后，编译器与运行时都会注意到这个变量是共享的，
     * 因此不会将该变量上的操作与其他内存操作一起重排序。volatile变量不会被缓存在寄存器或者对其他处理器不可见的地方，
     * 因此在读取volatile类型的变量时总会返回最新写入的值。
     * */
    private static volatile Singleton05 instance;

    private Singleton05(){}

    public static Singleton05 getInstance(){

        if (instance == null){
            synchronized (Singleton05.class){
                if (instance == null){
                    instance = new Singleton05();
                }
            }

        }
        return instance;
    }
}

