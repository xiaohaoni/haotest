package com.hao.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hao.domain.FsModelResult;
import com.hao.domain.FsPlateToken;
import com.hao.domain.ParkIssueRequest;
import com.hao.domain.Staff;
import com.hao.util.FuShiRestult;
import com.hao.util.ToStringUtlis;
import com.hao.util.WebClientUtils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 车牌发行
 *
 * @author zrh
 * @version 1.0
 * @date 2020-07-21 18:51
 **/
public class PlateIssueService {
    /**
     * SI0000067
     * 浙A219ZW
     * {"State":{"IsError":false,"RecordAffected":0,"IsSucess":true,"Code":0},"Model":{"OrganizationName":"默认部门","IdentNumber":0,"Email":"","Address":"","UseMode":1,"TcmName":"月租卡A","OrganizationId":"84C748FD-1F73-4A8F-A9D2-BFB43AC68D0C","Remark":"","TcmCode":"24","TokenType":0,"SubSystem":"1000000000","StaffStatus":0,"AccountBalance":0.0000,"ID":66,"TokenId":"浙A219ZW","MobileNo":"","SerialNo":"浙A219ZW","RoomNo":"","OperName":"岗亭","Gid":"32BAB824-392F-41AC-90BF-32217C743C7A","StaffId":"dc098a69-afff-4f6f-9898-b3b0f9196e20","RegDate":"2020-10-05T12:49:54","IssueDate":"2020-10-05T12:50:00","Rid":"ee664575-8330-4216-878e-5bd9c558d966","TelphoneNo":"","EndDate":"2029-12-31T23:59:59","StaffName":"陈方有","BeginDate":"2020-10-05T00:00:00","Plate":"浙A219ZW","LotNo":"","AuthDevice":"11111111","State":1,"TcmId":"C97611CE-C6EA-4582-9680-55934B79F9F7","TcmType":2,"IdNo":"","StaffNo":"SI0000067"},"Models":[{"OrganizationName":"默认部门","IdentNumber":0,"Email":"","Address":"","UseMode":1,"TcmName":"月租卡A","OrganizationId":"84C748FD-1F73-4A8F-A9D2-BFB43AC68D0C","Remark":"","TcmCode":"24","TokenType":0,"SubSystem":"1000000000","StaffStatus":0,"AccountBalance":0.0000,"ID":66,"TokenId":"浙A219ZW","MobileNo":"","SerialNo":"浙A219ZW","RoomNo":"","OperName":"岗亭","Gid":"32BAB824-392F-41AC-90BF-32217C743C7A","StaffId":"dc098a69-afff-4f6f-9898-b3b0f9196e20","RegDate":"2020-10-05T12:49:54","IssueDate":"2020-10-05T12:50:00","Rid":"ee664575-8330-4216-878e-5bd9c558d966","TelphoneNo":"","EndDate":"2029-12-31T23:59:59","StaffName":"陈方有","BeginDate":"2020-10-05T00:00:00","Plate":"浙A219ZW","LotNo":"","AuthDevice":"11111111","State":1,"TcmId":"C97611CE-C6EA-4582-9680-55934B79F9F7","TcmType":2,"IdNo":"","StaffNo":"SI0000067"}]}
     */
    public static void main(String[] args) {
        List<String> device = new ArrayList<>();
        device.add("1");
        device.add("2");
        device.add("3");
        device.add("4");
        device.add("5");
        device.add("6");
        device.add("7");
        device.add("8");
        //2021-01-13 9:00:00
        Long beginTime = 1610445600000L;
        // 2021-01-13 12:00:00
        Long endTime = 1610452800000L;
        updateParkModify("浙A3FR26", beginTime, endTime, device);
        //  savePlateIssue();

        //deferPlate("京B11180", beginTime, endTime);
        // updatePlate("粤BDQ133","粤BDQ233");
        FsPlateToken fsPlateToken = fetchPlate("plate = '浙A3FR26'");
        System.out.println(fsPlateToken);
        if (fsPlateToken == null) {
            System.out.println("!");
        } else {
            System.out.println("2");
        }

//{"State":{"IsError":false,"RecordAffected":0,"IsSucess":false,"Code":1},"Models":[]}
        // cancellationPlate("浙A219ZW");


    }


    /**
     * 添加车牌凭证 66
     */
    public static void savePlateIssue() {
        Staff staff = StaffService.fetchStaffById(85);
        System.out.println(staff);
        String url = "TokenService/Issue";
        ParkIssueRequest issueRequest = new ParkIssueRequest();
        issueRequest.setTokenOper(1);
        //issueRequest.setAlreadyIn(false);
        issueRequest.setTokenId(staff.getPlate());
        issueRequest.setSerialNo(staff.getPlate());
        issueRequest.setStaffNo(staff.getStaffNo());
        issueRequest.setStaffName(staff.getStaffName());
        issueRequest.setTelphoneNo(staff.getTelphoneNo());
        issueRequest.setOrginazitionId(staff.getOrganizationId());
        //卡的类型
        issueRequest.setTcm(ToStringUtlis.TCMA);
        //支付类型
        //issueRequest.setPayType(3);
        //issueRequest.setAccountBalance(0);
        issueRequest.setBeginDate(ToStringUtlis.dateLongStr(1603360733000L));
        issueRequest.setEndDate(ToStringUtlis.dateLongStr(1608631133000L));
        List<String> device = new ArrayList<>();
        device.add("1");
        device.add("2");
        device.add("3");
        device.add("4");
        device.add("5");
        device.add("6");
        device.add("7");
        device.add("8");
        issueRequest.setAuthDevice(device);
        issueRequest.setToken(staff.getPlate());
        issueRequest.setOperNo("999999");
        issueRequest.setOperName("超级管理员");
        //凭证类型
        issueRequest.setTokenType(0);
        issueRequest.setUseModel(1);
        issueRequest.setPlate(staff.getPlate());
        //issueRequest.setRedate(ToStringUtlis.dateStr(new Date()));
        issueRequest.setGid(staff.getGid());
        List<String> gids = new ArrayList<>();
        gids.add(staff.getGid());
        issueRequest.setProjectGidS(gids);
        //issueRequest.setId(0);
        //issueRequest.setIsLegal(true);
        Map<String, Object> paramMap = new HashMap<>();
        //0 表示车牌
        paramMap.put("TokenType", 0);
        //paramMap.put("Deposit", 0);
        //paramMap.put("IsWrite", false);
        //paramMap.put("Redate", ToStringUtlis.dateStr(new Date()));
        paramMap.put("ParkIssue", issueRequest);
        //paramMap.put("ID", 0);
        //paramMap.put("IsLegal", true);
        String body = null;
        try {
            body = WebClientUtils.postHttp(url, paramMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject bodyJson = JSONObject.parseObject(body);
        System.out.println(bodyJson);
        FuShiRestult result = JSON.parseObject(bodyJson.getString("State"), FuShiRestult.class);
        System.out.println(result);
        FsModelResult modelResult = JSON.parseObject(bodyJson.getString("Model"), FsModelResult.class);
        if (result.getCode() == 0) {
            System.out.println(modelResult);
            if (modelResult.getErrCode() == 0) {
                System.out.println("成功");
            } else {
                System.out.println(modelResult.getErrMessage());
            }
        } else {
            System.out.println(result.isSucess());
        }
    }

    /**
     * 注销  tokenType = 9 锁定 = 10 解锁
     */
    public static void cancellationPlate(String token) {
        String url = "TokenService/ParkUnregister";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("OperMoney", 0);
        //0 表示车牌
        paramMap.put("Token", token);
        paramMap.put("IsExistCard", true);
        //使用模式（写卡模式=0下载模式=1）
        paramMap.put("UseModel", 1);
        //表示车牌
        paramMap.put("TokenType", 12);
        paramMap.put("Remark", "车牌注销");
        paramMap.put("IsWrite", true);
        paramMap.put("OperNo", "999999");
        paramMap.put("OperName", "超级管理员");
        paramMap.put("Redate", new Date());
        paramMap.put("Gid", ToStringUtlis.GID);
        List<String> gidList = new ArrayList<>();
        gidList.add(ToStringUtlis.GID);
        paramMap.put("ProjectGids", gidList);
        paramMap.put("ID", 0);
        paramMap.put("IsLegal", true);
        String body = null;
        try {
            body = WebClientUtils.postHttp(url, paramMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        FuShiRestult restult = JSON.parseObject(body, FuShiRestult.class);
        System.out.println(restult);
    }

    /**
     * 解锁车牌凭证  todo 可以和锁定做成同一个接口
     */
    private static void unlockPlate() {
        String url = "TokenService/ParkUnLock";
        Map<String, Object> paramMap = new HashMap<>();
        //0 表示车牌
        paramMap.put("Token", "粤BDR134");
        //表示车牌
        paramMap.put("TokenType", 0);
        //使用模式（写卡模式=0下载模式=1）
        paramMap.put("UseModel", 1);
        paramMap.put("Plate", "粤BDR134");
        paramMap.put("TokenOper", 10);
        /* paramMap.put("OperNo", "操作员id");
        paramMap.put("OperName", "操作员name");*/
        paramMap.put("Redate", new Date());
        paramMap.put("Gid", ToStringUtlis.GID);
        paramMap.put("ID", 0);
        paramMap.put("IsLegal", true);
        String body = null;
        try {
            body = WebClientUtils.postHttp(url, paramMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject bodyJson = JSONObject.parseObject(body);
        System.out.println(bodyJson);
    }


    /**
     * 车牌凭证延期
     */
    private static FuShiRestult deferPlate(String plate, Long beginTime, Long endTime) {
        String url = "TokenService/ParkDefer";
        Map<String, Object> paramMap = new HashMap<>();

        //延期开始时间
        paramMap.put("EndDate", ToStringUtlis.dateLongStr(beginTime));
        //延期截止时间
        paramMap.put("DeferDate", ToStringUtlis.dateLongStr(endTime));
        paramMap.put("Token", plate);
        paramMap.put("Plate", plate);
        List<String> gids = new ArrayList<>();
        gids.add(ToStringUtlis.GID);
        paramMap.put("ProjectGids", gids);
        paramMap.put("Gid", ToStringUtlis.GID);
        //操作金额
        //paramMap.put("OperMoney", 0);
        //支付方式 12：其他
        //paramMap.put("PayType", 3);
        //paramMap.put("FreeMoney", 0);
        //paramMap.put("IsExistCard", false);
        //paramMap.put("TokenType", 0);
        //使用模式（写卡模式=0下载模式=1）
        //paramMap.put("UseModel", 1);
        //paramMap.put("TokenOper", 4);
        //paramMap.put("Redate", ToStringUtlis.dateStr(new Date()));

        //paramMap.put("OperNo", "999999");
        //paramMap.put("OperName", "超级管理员");
        //原金额
        //paramMap.put("OldAccountBlace", 0);
        //是否合法
        //paramMap.put("IsLegal", true);
        String body = null;
        try {
            body = WebClientUtils.postHttp(url, paramMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        FuShiRestult restult = JSON.parseObject(body, FuShiRestult.class);
        System.out.println(body);
        return restult;
    }


    /**
     * 车牌凭证延期审核
     */
    private static void admitDeferPlate() {
        String url = "TokenService/AdmitParkDefer";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("PayType", 3);
        paramMap.put("OperMoney", 0);
        //延期开始时间
        paramMap.put("EndDate", ToStringUtlis.stringDate("2020-07-30 06:00:00"));
        //延期截止时间
        paramMap.put("DeferDate", ToStringUtlis.stringDate("2020-07-30 18:00:00"));
        paramMap.put("FreeMoney", 0);
        paramMap.put("Token", "粤BDR139");
        //是否有卡
        paramMap.put("IsExistCard", false);
        //使用模式（写卡模式=0下载模式=1）
        paramMap.put("UseModel", 1);
        paramMap.put("Plate", "粤BDR139");
        paramMap.put("TokenOper", 4);
        paramMap.put("Remark", "延期审核");
        paramMap.put("OperNo", "999999");
        paramMap.put("OperName", "超级管理员");
        paramMap.put("Redate", new Date());
        List<String> gids = new ArrayList<>();
        gids.add(ToStringUtlis.GID);
        paramMap.put("ProjectGids", gids);
        paramMap.put("Gid", ToStringUtlis.GID);
        //操作金额
        paramMap.put("TokenId", "粤BDR139");
        paramMap.put("StaffNo", "SI0000006");
        paramMap.put("StaffName", "测试5");
        paramMap.put("TelphoneNo", "13687821469");
        paramMap.put("OldAccountBlace", 0);
        //是否合法
        paramMap.put("IsLegal", true);
        String body = null;
        try {
            body = WebClientUtils.postHttp(url, paramMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject bodyJson = JSONObject.parseObject(body);
        System.out.println(bodyJson);
    }


    /**
     * 车牌修改接口
     */
    private static void updatePlate(String newPlate, String oldPlate) {
        String url = "TokenService/ParkChangToken";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("NewToken", newPlate);
        paramMap.put("SerialNo", newPlate);
        paramMap.put("Token", oldPlate);
        paramMap.put("IsExistCard", false);
        //0车牌号
        paramMap.put("TokenType", 0);
        //使用模式（写卡模式=0下载模式=1）
        paramMap.put("UseModel", 1);
        paramMap.put("Plate", newPlate);
        paramMap.put("OperNo", "999999");
        paramMap.put("OperName", "超级管理员");
        paramMap.put("Redate", new Date());
        paramMap.put("OldAccountBlace", 0);
        paramMap.put("Gid", ToStringUtlis.GID);
        paramMap.put("IsLegal", true);
        String body = null;
        try {
            body = WebClientUtils.postHttp(url, paramMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject bodyJson = JSONObject.parseObject(body);
        System.out.println(bodyJson);
    }

    /**
     * 车牌查询接口
     *
     * @param condition 查询条件 如： id >1 and  id < 3
     */
    private static FsPlateToken fetchPlate(String condition) {
        String url = "IssueParkView/GetByFunc";
        String body = "";
        try {
            body = WebClientUtils.postJsonHttp(url, condition);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject bodyJson = JSONObject.parseObject(body);
        System.out.println(bodyJson);
        FuShiRestult result = JSON.parseObject(bodyJson.getString("State"), FuShiRestult.class);
        if (result.getCode() == 0) {
            FsPlateToken plateToken = JSON.parseObject(bodyJson.getString("Model"), FsPlateToken.class);
            return plateToken;
        } else {
            throw new RuntimeException("失败");
        }
    }

    static void updateParkModify(String plate, Long beginTime, Long endTime, List<String> authDevices) {
        String url = "TokenService/ParkModify";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("TokenId", plate);
        paramMap.put("OrginazitionId", ToStringUtlis.ORGANIZATION_RID);
        paramMap.put("Tcm", ToStringUtlis.TCMA);
        paramMap.put("BeginDate", cts2hms(beginTime));
        System.out.println(cts2hms(beginTime));
        paramMap.put("EndDate", cts2hms(endTime));
        //0车牌
        paramMap.put("TokenType", 0);
        paramMap.put("AuthDevice", authDevices);
        paramMap.put("OperNo", "999999");
        paramMap.put("OperName", "超级管理员");
        paramMap.put("Redate", new Date());
        paramMap.put("IsUpdateDate", true);
        paramMap.put("Token", plate);
        paramMap.put("Plate", plate);
        paramMap.put("IsExistCard", true);
        paramMap.put("TokenOper", 0);
        paramMap.put("Gid", ToStringUtlis.GID);
        List<String> gids = new ArrayList<>();
        gids.add(ToStringUtlis.GID);
        paramMap.put("ProjectGids", gids);
        paramMap.put("IsLegal", true);
        String body = null;
        try {
            body = WebClientUtils.postHttp(url, paramMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject bodyJson = JSONObject.parseObject(body);
        System.out.println(bodyJson);
    }

    static String _date2Str(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    static String cts2hms(long lTime) {
        Date date = new Date(lTime);
        return _date2Str(date);
    }

}
