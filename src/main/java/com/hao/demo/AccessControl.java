package com.hao.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hao.domain.DoorGrant;
import com.hao.util.FuShiRestult;
import com.hao.util.ToStringUtlis;
import com.hao.util.WebClientUtils;

import java.util.*;

/**
 * 门禁发行
 *
 * @author zrh
 * @version 1.0
 * @date 2020-07-22 14:34
 **/
public class AccessControl {
    public static void main(String[] args) {
        accessContolIssue();
    }

    /**
     * 门禁发行
     * */
    public static String accessContolIssue(){
        String url = "TokenService/DoorIssue";
        List<DoorGrant> grants = new ArrayList<>();
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("TokenOper",13);
        paramMap.put("TokenId","粤BDR139");
        paramMap.put("SerialNo","粤BDR139");
        paramMap.put("StaffNo","S10000002");
        paramMap.put("StaffName","测试2");
        paramMap.put("organizationId", ToStringUtlis.ORGANIZATION_RID);
        paramMap.put("Tcm",1);
        paramMap.put("BeginDate","2020-07-24 14:12:59");
        paramMap.put("EndDate","2020-07-25 23:59:59");
        paramMap.put("IcStartTimeL1","06:00");
        paramMap.put("IcStartTimeR1","08:00");
        paramMap.put("IcStartTimeL2","11:00");
        paramMap.put("IcStartTimeR2","15:00");
        paramMap.put("IcStartTimeL3","");
        paramMap.put("IcStartTimeR3","");
        paramMap.put("IcStartTimeL4","");
        paramMap.put("IcStartTimeR4","");
        //已验证 只验证这个车牌
        paramMap.put("Token","粤BDR139");
        paramMap.put("DoorGrant",grants);
        paramMap.put("IsExistCard",false);
        paramMap.put("TokenType",0);
        paramMap.put("Plate","粤BFB229");
        paramMap.put("OperNo","999999");
        paramMap.put("OperName","超级管理员");
        paramMap.put("Redate",new Date());
        paramMap.put("Gid", ToStringUtlis.GID);
        paramMap.put("Plate","粤BFB229");
        String body = null;
        try {
            body = WebClientUtils.postHttp(url, paramMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(body);
        JSONObject bodyJson = JSONObject.parseObject(body);
        FuShiRestult state = JSON.parseObject(bodyJson.getString("State"), FuShiRestult.class);
        System.out.println(state);
        switch (state.getCode()) {
            case 0:
                System.out.println(state.getDescribe());
                break;
            case 1:
                System.out.println(state.getDescribe());
                break;
            case 2:
                System.out.println(state.getDescribe());
                break;
            default:
                System.out.println(state.getDescribe());
        }
        return body;
    }

    /**
     * 门禁注销
     * */
    private static String cancellation(){
        String url = "TokenService/DoorUnregister";
        Map<String,Object> paramMap = new HashMap<>();
        //登记时的tokenId
        paramMap.put("Token","粤BDR134");
        paramMap.put("TokenType",0);
        paramMap.put("IsExistCard",false);
        //0：写卡模式  1：下载模式
        paramMap.put("UseModel",1);

        paramMap.put("Plate","粤BDR134");
        //9为锁定
        paramMap.put("TokenOper",9);
        paramMap.put("Redate",new Date());
        paramMap.put("OperNo","999999");
        paramMap.put("OperName","超级管理员");
        paramMap.put("Gid", ToStringUtlis.GID);
        paramMap.put("ID",7);
        paramMap.put("Rid", ToStringUtlis.getUUIdToString());
        String body = null;
        try {
            body = WebClientUtils.postHttp(url, paramMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(body);
        //JSONObject bodyJson = JSONObject.parseObject(body);
        FuShiRestult state = JSON.parseObject(body, FuShiRestult.class);
        System.out.println(state);
        switch (state.getCode()) {
            case 0:
                //System.out.println(state.isIsSucess());
                break;
            case 1:
                System.out.println(state.getDescribe());
                break;
            case 2:
                System.out.println(state.getDescribe());
                break;
            default:
                System.out.println(state.getDescribe());
        }
        return body;
    }

}
