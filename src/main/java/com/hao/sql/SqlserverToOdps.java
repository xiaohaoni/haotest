package com.hao.sql;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


public class SqlserverToOdps {
    public static void main(String[] args) throws Exception{
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

        Connection con = DriverManager.getConnection("jdbc:sqlserver://192.168.15.17:1433;DatabaseName=zytk35_plus","sjdj","sjdj");

        Date today = new Date(System.currentTimeMillis() - 1000*60*60*24);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String yesterday = simpleDateFormat.format(today);

        //查
        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet rsst = stmt.executeQuery("select a.Accno,a.inputdate from ac_dict_AccPicture a where substring(convert(varchar,InputDate,120),1,10)='"+yesterday+"'");
        while(rsst.next())
        {
            try {
                String uu = JpgToLoc(rsst.getBinaryStream("Pic"));
                System.out.println(rsst.getString("AccNo") + " " + uu);
            }catch (Exception e){
            }

        }
    }

    public static String JpgToLoc(InputStream zp){
        //InputStream in = null;
        //我这里测试是本地的一个图片获取byte数组，然后上次七牛，你这里改成读取数据库的二进制byte[]即可
        BufferedImage bi = null;
        byte[] data = null;
        try {
            bi = ImageIO.read(zp);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bi, "jpg", baos);  //经测试转换的图片是格式这里就什么格式，否则会失真
            data = baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println("-------");
        String key = UUID.randomUUID().toString().replaceAll("-", "").replaceAll("\\.", "") + ".jpg";
        //System.out.println(key);
        String buket = "bugu";
        Auth auth = Auth.create("WuaDH1ev5gpVEoDVorG-T_wchu3fre41865lHJpl", "JBadoGDvez7PPijlysGk2ifO8lIKOslmq-GfGeO4");
        String token = auth.uploadToken(buket);
        //图片
        String d = "";
        String url;
        Configuration cfg = new Configuration();
        try {
            UploadManager uploadManager = new UploadManager(cfg);
            //调用put方法上传
            Response res = uploadManager.put(data, key, token);
            //打印返回的信息
            //System.out.println(res.bodyString());
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            //try {
                //System.out.println(r.toString());
                //System.out.println(r.bodyString());
            //} catch (QiniuException qiniuException) {
                //qiniuException.printStackTrace();
            //}
        }
        url = "http://res.yunzhiyuan100.com/" + key;
        return url;
    }
}