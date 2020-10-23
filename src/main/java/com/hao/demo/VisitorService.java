package com.hao.demo;

import com.alibaba.fastjson.JSONObject;
import com.hao.util.ToStringUtlis;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 访客
 *
 * @author zrh
 * @version 1.0
 * @date 2020-07-22 16:37
 **/
public class VisitorService {

    /**
     * 访客预约
     * */
    public void visitorReserve(){
        String url = "VisitorServicePro/AddVisitorAPP";
        Map<String,Object> paramMap = new HashMap<>();
        //凭证编号
        paramMap.put("TokenId","车牌号");
        paramMap.put("VisitorName","访客名称");
        paramMap.put("CertificateType",0);

        paramMap.put("ContactTel","studentPhone");
        //0/1
        paramMap.put("UseType",0);
        //被访人(对应Staff表Rid(标识号))
        paramMap.put("PeopleInterviewed","studentRid");
        //开始时间
        paramMap.put("BeginDate",new Date());
        paramMap.put("EndDate",new Date());
        paramMap.put("Gid", ToStringUtlis.GID);
        String body = HttpDemo01.postHttp(url, null, paramMap);
        JSONObject bodyJson = JSONObject.parseObject(body);
        switch (bodyJson.getInteger("code")) {
            case 0:
                System.out.println("成功");
                break;
            case 1:
                System.out.println("成功没有数据");
                break;
            default:
                System.out.println("失败");
        }
    }

    public static void getInvehicle(){
        boolean result = false;
        String url = "http://192.168.1.62:60009/api/InVehicle/GetByCustom";
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("PageSize",1000);
        paramMap.put("CurrentPage",1);
        paramMap.put("OrderBy","id");
        paramMap.put("OrderType",true);
        paramMap.put("TotalCount",0);
       String body =  HttpDemo01.postHttp(url,null,paramMap);


    }

    public static void main(String[] args) {
        getInvehicle();
    }
}
