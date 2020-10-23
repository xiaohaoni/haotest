package com.hao.demo;

import com.alibaba.fastjson.JSONObject;
import com.hao.domain.Organization;
import com.hao.util.FuShiRestult;
import com.hao.util.ToStringUtlis;
import com.hao.util.WebClientUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 组织机构
 *
 * @author zrh
 * @version 1.0
 * @date 2020-07-21 15:31
 **/
public class OrganizationService {

    public static void main(String[] args) {
       // Long s = saveOrganization("接送人", "接送人", -1, ToStringUtlis.GID);
        Organization s = fetchOrganizationById(10L);
        System.out.println(s);
    }

    /**
     * 新增组织
     * @return 返回 主键id
     */
    public static Long saveOrganization(String name, String remark, Integer parentId, String gid) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("Name", name);
        paramMap.put("Remark", remark);
        paramMap.put("parentId", parentId);
        paramMap.put("Rid", ToStringUtlis.getUUIdToString());
        paramMap.put("Gid", gid);
        String url = "Organization/Add";
        String body = null;
        try {
            body = WebClientUtils.postHttp(url, paramMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = JSONObject.parseObject(body);
        System.out.println(jsonObject);
        if (jsonObject.getInteger("Code") == 0) {
            return jsonObject.getLong("Describe");
        }else {
            System.out.println("错误");
            return 0L;
        }
    }

    /**
     * 查询组织
     */
    public static String fetchAllOrganization() {
        String url = "Organization/GetByFunc";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("where", "id >0");
        String s = null;
        try {
            s = WebClientUtils.postHttp(url, paramMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;

    }

    public static Organization fetchOrganizationById(Long id) {
        String url = "Organization/Get/" + id;
        String body = null;
        try {
            body = WebClientUtils.getHttp(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(body);
        JSONObject jsonObject = JSONObject.parseObject(body);
        FuShiRestult fuShiRestult = JSONObject.parseObject(jsonObject.getString("State"), FuShiRestult.class);
        if (fuShiRestult.getCode() == 0){
            Organization organization = JSONObject.parseObject(jsonObject.getString("Model"), Organization.class);
            return organization;
        }else {
            return null;
        }
    }
}
