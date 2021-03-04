package com.hao.nio;

import org.junit.jupiter.api.Test;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

/**
 * 非阻塞模式
 *
 * @author zrh
 * @version 1.0
 * @date 2021-03-04 14:02
 **/
public class TestNonBlockingNio {
    @Test
    public void noBlockClient() throws Exception {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));

        //切换非阻塞模式
        socketChannel.configureBlocking(false);

        //分配到指定大小缓冲区
        ByteBuffer buf = ByteBuffer.allocate(100);

        //循环发送
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            if (str.equals("出去")) {
                break;
            }
            //发送数据给服务端
            buf.put((new Date().toString() + "\n" + str).getBytes());
            buf.flip();
            socketChannel.write(buf);
            buf.clear();
        }

        //读取本地文件

        socketChannel.close();
    }


    public static void main(String[] args) throws Exception {

        // blockService();
        //blockClient();
    }

    //服务端
    @Test
    public void blockService() throws Exception {
        //1 获取通道
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        // 2 切换非阻塞模式
        ssChannel.configureBlocking(false);

        //3 绑定连接
        ssChannel.bind(new InetSocketAddress(9898));

        //4 获取一个选择器
        Selector selector = Selector.open();

        //5 将通道注册到选择器上 ,并且指定“监听接收事件”
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);
        //6 轮询式的获取选择器上已经 准备就绪的事件
        while (selector.select() > 0) {
            //7 获取当前选择器中所有注册的选择键（以就绪的监听事件）
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey sk = iterator.next();
                //判断具体式什么事件准备就绪
                if (sk.isAcceptable()) {
                    //10,若准备就绪，获取连接
                    SocketChannel sChannel = ssChannel.accept();
                    //11 切换非阻塞模式
                    sChannel.configureBlocking(false);
                    //12将该通道注册到选择器上
                    sChannel.register(selector, SelectionKey.OP_READ);
                } else if (sk.isReadable()) {
                    //13 获取当前选择器上 读就绪的状态
                    SocketChannel schannel = (SocketChannel) sk.channel();

                    //14读取数据
                    ByteBuffer buf = ByteBuffer.allocate(1024);
                    int len = 0;
                    while ((len = schannel.read(buf)) > 0) {
                        buf.flip();
                        System.out.println(new String(buf.array(), 0, len));
                        buf.clear();
                    }
                }
                iterator.remove();
            }
        }
    }


}
