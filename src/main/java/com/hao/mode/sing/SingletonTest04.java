package com.hao.mode.sing;

/**
 * 懒汉式第二种
 *
 * @author zrh
 * @version 1.0
 * @date 2020-10-23 16:10
 **/
public class SingletonTest04 {
    public static void main(String[] args) {
        Singleton04 singleton02 = Singleton04.getInstance();
        Singleton04 singleton01 = Singleton04.getInstance();
        //true 内存地址相同
        System.out.println(singleton01 == singleton02);
    }
}

/**
 *
 * 优点：起来懒加载的效果
 * 加入了一个synchronized同步
 * 缺点：效率太低了，
 * 结论：在实际开发中，不推荐使用这种方式，
 * */
class Singleton04{
    private static Singleton04 instance;
    private Singleton04(){}
    public static synchronized Singleton04 getInstance(){
        if (instance == null){
            instance = new Singleton04();
        }
        return instance;
    }
}
