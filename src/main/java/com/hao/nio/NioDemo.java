package com.hao.nio;

import java.nio.ByteBuffer;

/**
 * @author zrh
 * @version 1.0
 * @date 2021-03-03 21:57
 * 缓冲区：负责数据的存储，就是数组，用用存储不同类型的数据
 * 根据不同的数据类型提供了不同类型的缓冲区 除了Boolean外
 * ByteBuffer
 * IntBuffer
 * CharBuffer
 * DoubleBuffer
 * 核心方法：
 * put():存储数据
 * get():得到数据
 * 重要核心属性：
 *private int mark:标记
 * position ：位置，正在操作缓冲区的位置
 *limit：可以操作数据的大小，
 *capacity：容器，最大存储数据的容量，只能声明一次
 *
 * 直接缓冲区和非直接缓冲区
 * 非直接缓冲区：allocate,方法分配到jvm中
 * 直接缓冲区：allocateDirect:直接分配到物理内存中 提高效率
 *
 *
 *
 **/
public class NioDemo {

    public static void main(String[] args) {


    }

    public static  void  test3(){
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        //判断是否为直接缓存区
        System.out.println(buffer.isDirect());
    }
    public static void test2(){
        String str = "asdfg";
        //分配一个指定大小的缓冲区
        ByteBuffer buf =  ByteBuffer.allocate(1024);
        buf.put(str.getBytes());
        //切换成读
        buf.flip();
        byte[] bytes = new byte[buf.limit()];
        buf.get(bytes,0,2);
        System.out.println(new String(bytes,0,2));
        System.out.println(buf.position());
//标记
        buf.mark();
        buf.get(bytes,2,2);
        System.out.println(new String(bytes,2,2));
        System.out.println(buf.position());
        //回到标记位置
        buf.reset();
        System.out.println(buf.position());
        //判断缓冲区是否还有
        if (buf.hasRemaining()){
            //还有多少可操作数量
            System.out.println(buf.remaining());
        }

    }

    public static void test1(){
        String str = "asdfg";
        //分配一个指定大小的缓冲区
        ByteBuffer buf =  ByteBuffer.allocate(1024);
        System.out.println("=====================allocate");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        buf.put(str.getBytes());
        System.out.println("=====================allocate");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
        //切换到读数据模式
        buf.flip();
        System.out.println("=====================allocate");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
        //拿数据
        byte b = buf.get();
        System.out.println(b);

    }
}
