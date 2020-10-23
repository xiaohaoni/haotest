package com.hao.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hao.domain.CarCurrentRecord;
import com.hao.domain.PushDada;
import com.hao.util.FuShiRestult;
import com.hao.util.WebClientUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 推送数据查询接口
 *
 * @author zrh
 * @version 1.0
 * @date 2020-07-22 10:16
 **/
public class GetByFuncService {

    public static final Integer OPER_TYPE_DELETE = 2;

    public static final Integer OPER_TYPE_SAVE = 0;

    public static final Integer OPER_TYPE_UPDATE = 1;

    /**
     * 获取推送信息
     * 0:新增
     * 1：修改
     * 2：删除
     */
    public static void fetchGetByFunData() {
        String url = "OperationMark/GetByFunc";
        String body = null;
        try {
            body = WebClientUtils.postHttp(url, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = JSONObject.parseObject(body);
        System.out.println(jsonObject);
        FuShiRestult fuShiRestult = JSON.parseObject(jsonObject.getString("State"), FuShiRestult.class);
        System.out.println(fuShiRestult);
        /*if (fuShiRestult.getCode() == 0) {
            String pushDataStrs = jsonObject.getString("model");
            List<PushDada> pushDadas = JSONObject.parseArray(pushDataStrs, PushDada.class);
            for (PushDada push : pushDadas) {
                if (push.getOperType() ==OPER_TYPE_SAVE){
                    saveCarRecord(push);
                }else {
                    deletePullData(push.getId());
                }
            }
        } else {
            System.out.println("访问失败");
        }*/

    }

    /**
     * 新增 车辆进出记录接口
     * 0/1 不知道哪个表示出入状态
     */
    public static void saveCarRecord(PushDada push) {

        switch (push.getTableName()) {
            //入
            case "[InVehicle]":
               // getIntoCarRecordByRid("rid = " + push.getRid());
                break;
            //出
            case "[OutVehicle]":
              //  getOutCarRecordPage("rid = " + push.getRid());
                break;
            default:
                deletePullData(push.getId());
        }
    }

    /**
     * 获取入场车辆记录查询
     *
     * @param where 条件 如rid = '974835B5-4D8F-4D96-AD3B-2AD38079893E' id>0
     */
    public static void getIntoCarRecordPage(String where, Integer pageSize, Integer currentPage, String orderBy, boolean orderType, Integer totalCount) {
        String url = "InVehicle/GetByCustom";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("PageSize", pageSize);
        paramMap.put("CurrentPage", currentPage);
        paramMap.put("OrderBy", orderBy);
        paramMap.put("OrderType", orderType);
        paramMap.put("TotalCount", totalCount);
        paramMap.put("where", where);
        String body = null;
        try {
            body = WebClientUtils.postHttp(url, paramMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject bodyJson = JSONObject.parseObject(body);
        System.out.println(bodyJson);
        FuShiRestult restult = JSON.parseObject(bodyJson.getString("State"), FuShiRestult.class);
        System.out.println(restult);
        if (restult.getCode() == 0) {
            List<CarCurrentRecord> records = JSONObject.parseArray(bodyJson.getString("Records"), CarCurrentRecord.class);
            System.out.println(records);
            for (CarCurrentRecord record : records) {
                //保存记录到数据库
            }
        } else {
            System.out.println("查询失败");
        }
    }

    public static void getIntoCarRecordByRid(Integer where) {
        getIntoCarRecordPage("id >"+where, 1000, 1, "id", true, 0);
    }

    public static void main(String[] args) {
        //getIntoCarRecordByRid(0);
        getOutCarRecordPage("id > 0");
        //fetchGetByFunData();
    }


    /**
     * 获取出车车辆记录查询
     */
    public static void getOutCarRecordPage(String where) {
        String url = "OutVehicle/GetByFunc";
        String outBody = null;
        try {
            outBody = WebClientUtils.postJsonHttp(url, where);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject outBodyJson = JSONObject.parseObject(outBody);
        System.out.println(outBodyJson);
        FuShiRestult restult = JSON.parseObject(outBodyJson.getString("State"), FuShiRestult.class);
        System.out.println(restult);
        if (restult.getCode() == 0) {
            List<CarCurrentRecord> records = JSONObject.parseArray(outBodyJson.getString("Models"), CarCurrentRecord.class);
            System.out.println(records);
            for (CarCurrentRecord record : records) {
                //保存记录到数据库
            }
        } else {
            System.out.println("查询失败");
        }

    }

    /**
     * 删除推送接口
     */
    public static void deletePullData(Integer id) {
        String url = "OperationMark/Delete/" + id;
        String body = "";
        try {
            body = WebClientUtils.deleteHttp(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (body != null) {
            System.out.println(body);
            FuShiRestult result = JSON.parseObject(body, FuShiRestult.class);
            if (result.getCode() == 0) {
                System.out.println("成功");
            } else {
                System.out.println("成功");
            }
        } else {
            System.out.println("删除失败！");
        }

    }


}
