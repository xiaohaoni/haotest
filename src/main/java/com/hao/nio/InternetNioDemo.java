package com.hao.nio;

import org.junit.jupiter.api.Test;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 网络io
 *
 * @author zrh
 * @version 1.0
 * @date 2021-03-04 09:45
 * 1.网络通道 Channel
 * SocketChannels
 * ServiceSocketChannels
 * DatagramChannels
 * 2.缓冲区： buffer
 * <p>
 * 2.选择器：selector:
 **/
public class InternetNioDemo {


    @Test
    public void blockClient() throws Exception {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
        FileChannel in = FileChannel.open(Paths.get("3.jpg"), StandardOpenOption.READ);
        //分配到指定大小缓冲区
        ByteBuffer buf1 = ByteBuffer.allocate(100);
        //读取本地文件
        while (in.read(buf1) != -1) {
            buf1.flip();
            socketChannel.write(buf1);
            buf1.clear();
        }
        //关闭通道
        in.close();
        socketChannel.close();
    }


    public static void main(String[] args) throws Exception {

        // blockService();
        //blockClient();
    }

    //服务端
    @Test
    public void blockService() throws Exception {
        //获取通道
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        FileChannel out = FileChannel.open(Paths.get("6.jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        //绑定链接
        ssChannel.bind(new InetSocketAddress(9898));

        //获取客户端链接的通道
        SocketChannel sChannel = ssChannel.accept();

        //4.分配指定大小缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        buf.put("服务端开始接收数据".getBytes());
        //接收客户的数据，并保存到本地
        while (sChannel.read(buf) != -1) {
            buf.flip();
            out.write(buf);
            buf.clear();
        }
        sChannel.close();
        out.close();
        ssChannel.close();

    }

    //=======================================nio接收服务端反馈==================================================


    @Test
    public void getMsgBlockClient() throws Exception {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
        FileChannel in = FileChannel.open(Paths.get("3.jpg"), StandardOpenOption.READ);
        //分配到指定大小缓冲区
        ByteBuffer buf1 = ByteBuffer.allocate(100);
        //读取本地文件
        while (in.read(buf1) != -1) {
            buf1.flip();
            socketChannel.write(buf1);
            buf1.clear();
        }
        //告知以发完 不然会阻塞
        socketChannel.shutdownOutput();
        System.out.println("读取数据成功，开始接收消息");
        //接收服务端反馈
        int len = 0;
        while ((len = socketChannel.read(buf1))!=-1){
            buf1.flip();
            System.out.println(new String(buf1.array(),0,len));
            buf1.clear();
        }
        //关闭通道
        in.close();
        socketChannel.close();
    }


    //服务端
    @Test
    public void sendMsgBlockService() throws Exception {
        //获取通道
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        FileChannel out = FileChannel.open(Paths.get("8.jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        //绑定链接
        ssChannel.bind(new InetSocketAddress(9898));

        //获取客户端链接的通道
        SocketChannel sChannel = ssChannel.accept();

        //4.分配指定大小缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);

        buf.put("服务端开始接收数据".getBytes());
        //接收客户的数据，并保存到本地
        while (sChannel.read(buf) != -1) {
            buf.flip();
            out.write(buf);
            buf.clear();
        }

        System.out.println("接收数据成功，发送消息");
        //发送反馈给客户端
        buf.put("服务端接收数据ok".getBytes());
        buf.flip();
        sChannel.write(buf);

        sChannel.close();
        out.close();
        ssChannel.close();

    }


}
