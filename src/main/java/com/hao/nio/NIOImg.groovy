package com.hao.nio

import java.nio.MappedByteBuffer
import java.nio.channels.FileChannel
import java.nio.file.Paths
import java.nio.file.StandardOpenOption

/**
 *
 *
 *  ${description}*
 * @author zrh* @version 1.0* @date 2021-03-09 17:44 * */
class NIOImg {

    public static void main(String[] args) {
    }

    public void img(String img)throws Exception{
        URL imgUrl = new URL(img + "!face");
        InputStream inputStream = imgUrl.openStream();
        //byte[] bytes = inputStream.read();
        //String encoded = bytes.encodeBase64().toString();
        FileChannel fileChannel = FileChannel.open(Paths.get("E:\\file\\1.jpg"), StandardOpenOption.READ);
        //内存映射文件
        MappedByteBuffer inMap = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
        //直接对直接缓冲区进行读写
        byte[] bytes = new byte[inMap.limit()];
        inMap.get(bytes);
    }

}
