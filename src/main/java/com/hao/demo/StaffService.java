package com.hao.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hao.domain.Staff;
import com.hao.util.FuShiRestult;
import com.hao.util.ToStringUtlis;
import com.hao.util.WebClientUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 人事添加
 *
 * @author zrh
 * @version 1.0
 * @date 2020-07-21 15:01
 **/
public class StaffService {
    /**
     * organizationId=84C748FD-1F73-4A8F-A9D2-BFB43AC68D0C
     * organizationId=6863eb11-4c2d-4383-b375-acd739aaea2f
     */
    //千亿
    public static final Long MYRIADS = 100000000000L;
    //十亿
    public static final Long BILLION = 1000000000L;

    /**
     * 66 陈方有
     * 85：陈总
     *
     */
    public static void main(String[] args) {
        // FuShiRestult s = saveStaff(7000002L, "测试82", "京B11180", ToStringUtlis.ORGANIZATION_RID, ToStringUtlis.getUUIdToString());
        // FuShiRestult s = updateStaff(42L, 42L, "sdf", "13693941348", "粤BDQ315");
        //System.out.println(s);
        //SI0000077
        //Staff staff = fetchStaffById(Integer.parseInt(fuShiRestult.getDescribe()));
        Staff staff = fetchStaffById(85);
        //  System.out.println(staff);
       // fetchAllStaffPage();
        //fetchAllStaffPage();
        // deleteStaff("id = 80");
        //FuShiRestult restult = deleteStaff("id = 1");
        // System.out.println(restult);
    }

    /**
     * 添加人事
     */
    public static FuShiRestult saveStaff(Long id, String name, String licencePlate, String organizationRid, String uuid) {

        String url = "Staff/Add";
        String staffNo = idChangeStaffNo(id);
        Map<String, Object> paramMap = new HashMap<>();
        //家长id
        paramMap.put("staffNo", staffNo);
        paramMap.put("staffName", name);
        paramMap.put("plate", licencePlate);
        paramMap.put("organizationId", organizationRid);
        paramMap.put("rollDate", ToStringUtlis.dateStr(new Date()));
        paramMap.put("rid", uuid);
        paramMap.put("gid", ToStringUtlis.GID);
        String body = null;
        try {
            body = WebClientUtils.postHttp(url, paramMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        FuShiRestult result = JSON.parseObject(body, FuShiRestult.class);
        System.out.println(result);
        if (result != null) {
            System.out.println(result.getDescribe());
            Integer staffId = Integer.parseInt(result.getDescribe());
            System.out.println(staffId);
            Staff staff = fetchStaffById(staffId);
            System.out.println(staff);
        }

        return result;
    }

    /**
     * 修改人事
     */
    public static FuShiRestult updateStaff(Long staffId, Long id, String name, String mobileNo, String licencePlate) {
        String url = "StaffService/EditStaff";
        String no = 10000000 + id + "";
        String staffNo = no.replaceFirst("1", "SI");
        Map<String, Object> paramMap = new HashMap<>();
        //家长id
        paramMap.put("staffNo", staffNo);
        //家长id
        paramMap.put("id", staffId);
        paramMap.put("staffName", name);
        paramMap.put("mobileNo", mobileNo);
        paramMap.put("plate", licencePlate);
        paramMap.put("organizationId", ToStringUtlis.ORGANIZATION_RID);
        paramMap.put("rollDate", ToStringUtlis.dateStr(new Date()));
        paramMap.put("rid", ToStringUtlis.getUUIdToString());
        paramMap.put("gid", ToStringUtlis.GID);
        String body = null;
        try {
            body = WebClientUtils.postHttp(url, paramMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        FuShiRestult restult = JSON.parseObject(body, FuShiRestult.class);
        return restult;
    }

    public static List<Staff> fetchAllStaffPage() {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("PageSize", 1000);
        paramMap.put("CurrentPage", 1);
        paramMap.put("OrderBy", "id");
        paramMap.put("OrderType", true);
        paramMap.put("TotalCount", 0);
        paramMap.put("where", "");
        String url = "Staff/GetByCustom";
        String body = null;
        try {
            body = WebClientUtils.postHttp(url, paramMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(body);
        JSONObject object = JSONObject.parseObject(body);
        FuShiRestult result = JSON.parseObject(object.getString("State"), FuShiRestult.class);
        if (result.getCode() == 0) {
            List<Staff> staffList = JSON.parseArray(object.getString("Records"), Staff.class);
            System.out.println(staffList);
            return staffList;
        } else {
            throw new RuntimeException("失败");
        }
    }

    public static Staff fetchStaffById(Integer id) {
        String url = "Staff/Get/" + id;
        String body = null;
        try {
            body = WebClientUtils.getHttp(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject bodyJson = JSONObject.parseObject(body);
        System.out.println(body);
        FuShiRestult state = JSON.parseObject(bodyJson.getString("State"), FuShiRestult.class);
        if (state.getCode() == 0) {
            Staff staff = JSON.parseObject(bodyJson.getString("Model"), Staff.class);
            return staff;
        } else {
            return new Staff();
        }
    }

    /**
     * 删除人事
     */
    static FuShiRestult deleteStaff(String where) {
        String url = "Staff/DeleteFunc";
        String body = "";
        try {
            body = WebClientUtils.postJsonHttp(url, where);
        } catch (Exception e) {
            e.printStackTrace();
        }
        FuShiRestult result = JSON.parseObject(body, FuShiRestult.class);
        return result;
    }

    /**
     * 根据接送人id生成staffNo
     */
    static String idChangeStaffNo(Long id) {
        String no = 10000000L + id + "";
        String staffNo = no.replaceFirst("1", "SI");
        return staffNo;
    }

    /**
     * 根据 staffNo 转换成 long id SI0000077
     */
    static Long noStrChangeIdLong(String staffNo) {
        if (!StringUtils.isEmpty(staffNo)) {
            String idStr = staffNo.replaceFirst("SI", "1");
            String idStr2 = idStr.replaceFirst("1", "0");
            return Long.parseLong(idStr2);
        } else {
            return null;
        }
    }

    /**
     * 根据接送人id生成staffNo
     */
    static String idChangeStaffNoAndType(Long id, Byte userType) {
        String no = (MYRIADS + id) + userType * BILLION + "";
        String staffNo = no.replaceFirst("1", "SI");
        return staffNo;
    }

    /**
     * 根据 staffNo 转换成 long id SI0000077
     */
    static Long noStrChangeIdLongAndType(String staffNo, Byte userType) {
        if (!StringUtils.isEmpty(staffNo)) {
            String idStr = staffNo.replaceFirst("SI", "1");
            String id = Long.parseLong(idStr) - userType * BILLION + "";
            String idStr2 = id.replaceFirst("1", "0");
            return Long.parseLong(idStr2);
        } else {
            return null;
        }
    }


}
