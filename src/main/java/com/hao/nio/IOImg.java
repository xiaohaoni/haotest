package com.hao.nio;

import org.junit.jupiter.api.Test;

import java.net.URL;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author zrh
 * @version 1.0
 * @date 2021-03-09 17:36
 **/
public class IOImg {

    public static void main(String[] args) {

    }

    @Test
    public void img() throws Exception {
        String url = "http://res.yunzhiyuan100.com/ff9133ec3f0f4fec89babae0752e3e8a.jpg";
        URL imgUrl = new URL(url + "!face");
        /*  InputStream inputStream = imgUrl.openStream();
        byte[] bytes = inputStream.read();
        String encoded = bytes.encodeBase64().toString();*/
        FileChannel in = FileChannel.open(Paths.get(String.valueOf(imgUrl)), StandardOpenOption.READ);
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

    @Test
    public void encodeImgageToBase64()throws Exception {
        String remark="http://res.yunzhiyuan100.com/ff9133ec3f0f4fec89babae0752e3e8a.jpg";
        String newImg  = remark.replaceFirst("http","https");
        System.out.println(newImg);



    }

}
