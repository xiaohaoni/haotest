package com.hao.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hao.domain.Device;
import com.hao.util.FuShiRestult;
import com.hao.util.ToStringUtlis;
import com.hao.util.WebClientUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试
 *
 * @author zrh
 * @version 1.0
 * @date 2020-07-25 10:30
 **/
public class DeviceService {
    public static void main(String[] args) {
        Device deviceShow = getDeviceShow(2);
        System.out.println(deviceShow);
    }

    public static String saveOrUpdateDevice(Device device) {
        String url = "DmsDevice/Add";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("ID",device.getId());
        //设备号
        paramMap.put("DevNo", device.getDevNo());
        //设备地址（TCP=IP地址:端口号、485=COM号:波特率）
        paramMap.put("DevAddr", device.getDevAddr());
        //设备通信类别（TCP/485）
        paramMap.put("CommType", device.getCommType());
        //设备名称
        paramMap.put("DevName", device.getDevName());
        //设备类型标识码（详见附表一人脸门禁设备类别） 1 车管系统
        paramMap.put("DevTypeCode", device.getDevTypeCode());
        //系列代码（详见附表一人脸门禁设备类别）
        paramMap.put("CollectCode", device.getCollectCode());
        //系列代码（详见附表一人脸门禁设备类别）
        paramMap.put("Remark", device.getRemark());
        //所属组
        paramMap.put("GroupId", ToStringUtlis.ORGANIZATION_RID);
        //项目编号
        paramMap.put("Gid", ToStringUtlis.GID);
        //唯一标示
        paramMap.put("Rid", ToStringUtlis.getUUIdToString());
        String s = null;
        try {
            s = WebClientUtils.postHttp(url, paramMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(s);
        return s;
    }

    public static Device getDeviceShow(Integer id) {
        String url = "DmsDevice/Get/" + id;
        String body = null;
        try {
            body = WebClientUtils.getHttp(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(body);
        JSONObject jsonBody = JSON.parseObject(body);
        FuShiRestult result = JSON.parseObject(jsonBody.getString("State"), FuShiRestult.class);
        Device device = JSON.parseObject(jsonBody.getString("Model"), Device.class);
        return device;
    }

    public static List<Device> pageDevice() {
        String url = "DmsDevice/GetByCustom";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("PageSize", 1000);
        paramMap.put("CurrentPage", 1);
        paramMap.put("OrderBy", "id");
        paramMap.put("OrderType", true);
        paramMap.put("TotalCount", 0);
        String body = null;
        try {
            body = WebClientUtils.postHttp(url, paramMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject jsonBody = JSON.parseObject(body);
        FuShiRestult result = JSON.parseObject(jsonBody.getString("State"), FuShiRestult.class);
        List<Device> deviceList = JSON.parseArray(jsonBody.getString("Records"), Device.class);
        System.out.println(deviceList);
        System.out.println(result);
        System.out.println(body);
        return deviceList;
    }

    public static String deleteDevice(String where){
        if (where == null){
            where = "id = 1 ";
        }
        String url = "DmsDevice/DeleteFunc";

        String body = null;
        try {
            body = WebClientUtils.postJsonHttp(url,where);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(body);
        return body;
    }


}
