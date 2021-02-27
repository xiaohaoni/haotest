package com.hao.json;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author zrh
 * @version 1.0
 * @date 2021-02-26 15:17
 **/
public class JsonString {
    /**
     * string str = [code:1000, data:[todoCount:1131, totalCount:null, items:[[cameraId:null, count:12, algoModel:Blacklist], [cameraId:null, count:644, algoModel:CrossLine], [cameraId:null, count:475, algoModel:LeaveSeat]]], requestId:dudnhgkzwmkcyaubufohpwwjjfxcyjqe_1614306408564_15981, success:true, message:SUCCESS]
     */
    public static void main(String[] args) {
        String str = "[code:1000, data:[todoCount:1131, totalCount:null, items:[[cameraId:null, count:12, algoModel:Blacklist], [cameraId:null, count:644, algoModel:CrossLine], [cameraId:null, count:475, algoModel:LeaveSeat]]], requestId:dudnhgkzwmkcyaubufohpwwjjfxcyjqe_1614306408564_15981, success:true, message:SUCCESS]";
        //先转jsonObj 在转list
        JSONObject jsonObject = JSONObject.parseObject(str);
        List<EventAlertCountDTO> alertCountDTOList = JSONObject.parseArray(jsonObject.getString("items"), EventAlertCountDTO.class);

    }
}

class EventAlertCountDTO {
    String cameraId;
    String algoModel;
    String count;
}
