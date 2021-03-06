package com.hao.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.Set;

/**
 * 通道
 *
 * @author zrh
 * @version 1.0
 * @date 2021-03-03 22:48
 * java.nio.channels.Channel;包下
 **/
public class ChannelDemo {
    public static void main(String[] args) throws Exception {
        test6();
    }

    /**
     * 字符集
     * 编码：字符串---》字符数组
     * 解码：字节数组 -》字符集
     */
    public static void test6() throws Exception {
        Charset cs1 = Charset.forName("GBK");
        //获取编码器
        CharsetEncoder ce = cs1.newEncoder();
        //解码器
        CharsetDecoder cd = cs1.newDecoder();
        CharBuffer cf = CharBuffer.allocate(1024);
        cf.put("祝仁浩");
        cf.flip();
        //编码
        ByteBuffer bf = ce.encode(cf);
        for (int i = 0; i < 6; i++) {
            System.out.println(bf.get());
        }
        //解码
        bf.flip();
        CharBuffer charBuffer = cd.decode(bf);
        System.out.println(charBuffer.toString());

    }

    /**
     * 字符集
     * 编码：字符串---》字符数组
     * 解码：字节数组 -》字符集
     */
    public static void test5() {
        Map<String, Charset> map = Charset.availableCharsets();
        Set<Map.Entry<String, Charset>> set = map.entrySet();
        for (Map.Entry<String, Charset> entry : set) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

    }

    /**
     * 分散与聚集
     */
    public static void test4() throws IOException {

        RandomAccessFile raf1 = new RandomAccessFile("E:\\file\\1.txt", "rw");
        //获取通道
        FileChannel fileChannel = raf1.getChannel();

        //分配到指定大小缓冲区
        ByteBuffer buf1 = ByteBuffer.allocate(100);
        ByteBuffer buf2 = ByteBuffer.allocate(1024);
        //分散读取
        ByteBuffer[] bufs = {buf1, buf2};
        fileChannel.read(bufs);
        for (ByteBuffer buffer : bufs) {
            buffer.flip();
        }
        System.out.println(new String(bufs[0].array(), 0, bufs[0].limit()));
        System.out.println("=====================================================");
        System.out.println(new String(bufs[1].array(), 0, bufs[1].limit()));

        //聚集写入
        RandomAccessFile raf2 = new RandomAccessFile("E:\\file\\2.txt", "rw");
        FileChannel channel = raf2.getChannel();
        channel.write(bufs);
    }

    /**
     * 使用直接内存（内存映射的方式）
     */
    public static void test3() throws IOException {
        FileChannel in = FileChannel.open(Paths.get("E:\\file\\1.jpg"), StandardOpenOption.READ);
        FileChannel out = FileChannel.open(Paths.get("E:\\file\\5.jpg"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);
        long l = in.transferTo(0, in.size(), out);
        in.close();
        out.close();
    }

    /**
     * 使用直接内存（内存映射的方式）
     */
    public static void test2() throws IOException {
        FileChannel in = FileChannel.open(Paths.get("E:\\file\\1.jpg"), StandardOpenOption.READ);
        FileChannel out = FileChannel.open(Paths.get("E:\\file\\3.jpg"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);
        //内存映射文件
        MappedByteBuffer inMap = in.map(FileChannel.MapMode.READ_ONLY, 0, in.size());
        MappedByteBuffer outMap = out.map(FileChannel.MapMode.READ_WRITE, 0, in.size());
        //直接对直接缓冲区进行读写
        byte[] bytes = new byte[inMap.limit()];
        inMap.get(bytes);
        outMap.put(bytes);
        in.close();
        out.close();
    }

    /**
     * 利用通道复制一个文件
     */
    public static void test() throws Exception {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel inC = null;
        FileChannel outC = null;

        try {
            fis = new FileInputStream("E:\\file\\1.jpg");
            fos = new FileOutputStream("E:\\file\\2.jpg");
            inC = fis.getChannel();
            outC = fos.getChannel();
            //设置一个初始大小的缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            //将通道中的数据存入缓冲区中
            while (inC.read(buffer) != -1) {
                buffer.flip();
                //将缓冲区的数据写入通道中
                outC.write(buffer);
                //清空缓冲  区
                buffer.clear();
            }
        } catch (Exception e) {

        } finally {
            if (fis != null) {
                fis.close();
            }
            if (fos != null) {
                fis.close();
            }
            if (inC != null) {
                inC.close();
            }
            if (outC != null) {
                outC.close();
            }
        }


    }

}
