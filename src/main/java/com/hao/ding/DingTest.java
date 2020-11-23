package com.hao.ding;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.*;
import com.dingtalk.api.response.*;
import com.hao.ding.domain.EducationBureauBO;
import com.hao.ding.domain.SchoolDataStatisticsBO;
import com.hao.ding.domain.SchoolTypeDataBO;
import com.taobao.api.ApiException;
import sun.misc.Request;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zrh
 * @version 1.0
 * @date 2020-11-05 15:21
 **/
public class DingTest {

    /**
     * appid
     * 西湖大屏：951654080
     * 测试：949224878
     */
    static final String AGENTID = "951654080";

    /**
     * appkey
     * 西湖大屏 suitedpxwwc9whwxy6duv
     * 测试 suite9tqghapfkdshgqfb
     */
    static final String CUSTOM_KEY = "suitedpxwwc9whwxy6duv";

    /**
     * appSecret
     * 西湖大屏：xAc9TVxejiDjqSRTxE1HC6GafNAC2khF9tPJkFx0Twq9VwtaJbnHj1cmZ7Ggwm84
     * 测试：2ycnvCRImThKqCR_-L3lLXn75W0fJ1aougI0a3MgQ7jjhQPI44MJCnNQWvxQJR4F
     */
    static final String CUSTOM_SECRET = "xAc9TVxejiDjqSRTxE1HC6GafNAC2khF9tPJkFx0Twq9VwtaJbnHj1cmZ7Ggwm84";
    //dinge276cd0881e4856635c2f4657eb6378f
    /**
     * 测试：dinga037a072bf3af42fbc961a6cb783455b
     * 西湖：dinge276cd0881e4856635c2f4657eb6378f
     * */
    static final String CORP_ID = "dinge276cd0881e4856635c2f4657eb6378f";
    //注意ticket参数是通过dingOne钉钉云接口获取的，且做好缓存 @see http://118.178.91.15/api/dingone/corpInfo?corpId=ding099060891023dbff35c2f4657eb6378f
    static final String ticket = "7PQuh5pHAAKPGzjXJNYRt7IFkeQrqdIER2jBRhJnXsu5g33dxOgjAs2JDhYfahAzukjHTv3jKMEYT0S165PuYW";

    static final String token = "c87a9df78cef3eb6b125243a318634dd";


    static String getToken() throws ApiException {
        DefaultDingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/service/get_corp_token");
        OapiServiceGetCorpTokenRequest req = new OapiServiceGetCorpTokenRequest();
        req.setAuthCorpid(CORP_ID);
        OapiServiceGetCorpTokenResponse execute = client.execute(req, CUSTOM_KEY, CUSTOM_SECRET, "suiteTicket");
        System.out.println(execute.getAccessToken());
        return execute.getAccessToken();
    }

    static String getAccessToken() throws ApiException {
        DefaultDingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/gettoken");
        OapiGettokenRequest request = new OapiGettokenRequest();
        request.setAppkey(CUSTOM_KEY);
        request.setAppsecret(CUSTOM_SECRET);
        request.setHttpMethod("GET");
        OapiGettokenResponse response = client.execute(request);
        return response.getAccessToken();
    }


    static void educationGet() throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/edu/main/data/get");
        OapiEduMainDataGetRequest req = new OapiEduMainDataGetRequest();
        req.setStatDate("20201109");
        req.setHttpMethod("POST");
        OapiEduMainDataGetResponse rsp = client.execute(req, token);
        String body = rsp.getBody();
        JSONObject bodyJson = JSONObject.parseObject(body);
        if (bodyJson.getInteger("errcode") == 0) {
            EducationBureauBO educationBureauBO = JSON.parseObject(bodyJson.getString("result"), EducationBureauBO.class);
            System.out.println(educationBureauBO);
        } else {
            System.out.println("为空");
        }
        System.out.println(rsp.getBody());
    }

    public static void main(String[] args) throws ApiException {
        //getUserCreatTableData();
        accordingToContextData("PROC-87EE35B5-AF64-44DF-8A83-BCB188C7A29A");
    }

    static List<SchoolDataStatisticsBO> schoolGet(Long pageNum) throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/edu/sub/data/get");
        OapiEduSubDataGetRequest req = new OapiEduSubDataGetRequest();
        req.setStatDate("20201110");
        req.setHttpMethod("POST");
        req.setPageSize(58L);
        req.setPageNum(pageNum);
        OapiEduSubDataGetResponse rsp = client.execute(req, token);
        String body = rsp.getBody();
        JSONObject bodyJson = JSONObject.parseObject(body);
        List<SchoolDataStatisticsBO> list = new ArrayList<>();
        if (bodyJson.getInteger("errcode") == 0) {
            list = JSON.parseArray(bodyJson.getString("result"), SchoolDataStatisticsBO.class);
            System.out.println(list);
        }
        return list;
    }

    static void schoolTypeGet() throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/edu/type/data/get");
        OapiEduTypeDataGetRequest req = new OapiEduTypeDataGetRequest();
        req.setStatDate("20201108");
        req.setPageSize("20");
        req.setPageNum("1");
        OapiEduTypeDataGetResponse rsp = client.execute(req, token);
        String body = rsp.getBody();
        JSONObject bodyJson = JSONObject.parseObject(body);
        if (bodyJson.getInteger("errcode") == 0) {
            List<SchoolTypeDataBO> schoolTypeDataBOList = JSON.parseArray(bodyJson.getString("result"), SchoolTypeDataBO.class);
            System.out.println(schoolTypeDataBOList.size());
        } else {
            System.out.println("为空");
        }
        System.out.println(rsp.getBody());
        System.out.println(bodyJson);
        System.out.println(rsp.getBody());
    }


    static void getName() throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/edu/sub/data/get");
        OapiEduSubDataGetRequest req = new OapiEduSubDataGetRequest();
        req.setStatDate("20191201");
        req.setPageSize((long) 20);
        req.setPageNum((long) 1);
        OapiEduSubDataGetResponse rsp = client.execute(req, token);
        System.out.println(rsp.getBody());
    }

    static void getUserCreatTableData() throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/collection/form/list");
        OapiCollectionFormListRequest req = new OapiCollectionFormListRequest();
        //填表类型。0表示通用智能填表，1表示教育版填表
        /* req.setBizType(0L);
        req.setCreator("userid");*/
        req.setOffset(0L);
        req.setSize(200L);
        OapiCollectionFormListResponse rsp = client.execute(req, token);
        System.out.println(rsp.getBody());
    }

    static void accordingToContextData(String formCode) throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/collection/instance/list");
        OapiCollectionInstanceListRequest req = new OapiCollectionInstanceListRequest();
        req.setFormCode(formCode);
        //req.setActionDate("2020-02-02");
        req.setOffset(0L);
        req.setSize(20L);
        OapiCollectionInstanceListResponse rsp = client.execute(req, token);
        System.out.println(rsp.getBody());
    }

    /**
     *  String teacher_send_ding_cnt_1d
     *     String act_teacher_cnt_7d
     *     String class_card_user_cnt_7d
     *     String auth_teacher_cnt_std
     *     String act_patriarch_cnt_1d
     *     String send_circle_post_cnt_1d
     *     String act_class_circle_cnt_7d
     *     String act_class_circle_cnt_1d
     *     String school_cnt_std
     *     String act_class_group_cnt_1d
     *     String rcv_ding_patriarch_cnt_7d
     *     String class_cnt_std
     *     String class_group_user_cnt_1d
     *     String patriarch_cnt_std
     *     String act_class_group_cnt_7d
     *     String act_patriarch_cnt_7d
     *     String stat_date
     *     String class_circle_user_cnt_1d
     *     String corp_id
     *     String teacher_send_ding_cnt_7d
     *     String student_cnt_std
     *     String class_group_user_cnt_7d
     *     String rcv_ding_patriarch_cnt_1d
     *     String class_card_user_cnt_1d
     *     String class_circle_user_cnt_7d
     *     String act_teacher_cnt_1d
     *     String teacher_cnt_std
     *     String send_circle_post_cnt_7d
     * */


}
