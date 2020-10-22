package com.hao.jvm;

import java.nio.ByteBuffer;
import java.util.Scanner;

/**
 * 直接内存
 *
 * @author zrh
 * @version 1.0
 * @date 2020-10-07 12:29
 **/
public class BufferTest {
    private static final int BUFFER= 1024 * 1024 *1024;
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(BUFFER);
        System.out.println("直接内存分配完毕");
        Scanner scanner = new Scanner(System.in);
        scanner.next();
        System.out.println("直接释放内存");
        byteBuffer  = null;
        System.gc();
    }
}
