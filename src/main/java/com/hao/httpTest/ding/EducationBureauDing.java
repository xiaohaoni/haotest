package com.hao.httpTest.ding;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiEduMainDataGetRequest;
import com.dingtalk.api.response.OapiEduMainDataGetResponse;
import com.taobao.api.ApiException;

/**
 * 教育局钉钉测试
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-03 14:31
 **/
public class EducationBureauDing {
    private static final String ACCESS_TOKEN = "";
    public static void main(String[] args) throws ApiException {
        DingTalkClient client =
                new DefaultDingTalkClient("https://oapi.dingt alk.com/topapi/edu/group/msg/send");
        OapiEduMainDataGetRequest req = new OapiEduMainDataGetRequest();
        req.setStatDate("20191201");
        OapiEduMainDataGetResponse rsp = client.execute(req, ACCESS_TOKEN);
        System.out.println(rsp.getBody());

    }
}
