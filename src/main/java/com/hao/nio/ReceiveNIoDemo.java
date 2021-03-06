package com.hao.nio;

import org.junit.jupiter.api.Test;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * nio测试
 *
 * @author zrh
 * @version 1.0
 * @date 2021-03-06 09:42
 **/
public class ReceiveNIoDemo {


    @Test
    public void getMsgBlockClient() throws Exception {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8080));
        String str = "祝仁浩 write";
        //分配一个指定大小的缓冲区
        ByteBuffer buf =  ByteBuffer.allocate(1024);
        buf.put(str.getBytes());
        //将消息写入通道中
        socketChannel.write(buf);
        //告知以发完 不然会阻塞
        socketChannel.shutdownOutput();
        System.out.println("写入数据成功，开始接收反馈消息");
        //接收服务端反馈
        int len = 0;
        while ((len = socketChannel.read(buf))!=-1){
            buf.flip();
            System.out.println(new String(buf.array(),0,len));
            buf.clear();
        }
        //关闭通道
        socketChannel.close();
    }


    /**
     * 服务端
     */
    @Test
    public void service() throws Exception {
        //打开通道
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        //绑定端口
        ssChannel.bind(new InetSocketAddress(8080));
        //获取客户端链接的通道
        SocketChannel sChannel = ssChannel.accept();
        //4.分配指定大小缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        //buf.put("服务端开始接收数据".getBytes());
        System.out.println("读取数据成功，开始接收消息");
        //接收服务端反馈
        int len = 0;
        while (sChannel.read(buf) != -1) {
        }
       // sChannel.read(buf);
        buf.flip();
        System.out.println("读客户端数据:"+new String(buf.array(), 0, len));
        //接收消息后发送反馈
        buf.put("服务端接收数据ok".getBytes());
        buf.flip();
        sChannel.write(buf);
        //关闭通道
        ssChannel.close();
        sChannel.close();

    }
}
