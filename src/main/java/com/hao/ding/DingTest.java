package com.hao.ding;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiCollectionFormListRequest;
import com.dingtalk.api.request.OapiEduMainDataGetRequest;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.request.OapiServiceGetCorpTokenRequest;
import com.dingtalk.api.response.OapiCollectionFormListResponse;
import com.dingtalk.api.response.OapiEduMainDataGetResponse;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.dingtalk.api.response.OapiServiceGetCorpTokenResponse;
import com.taobao.api.ApiException;

/**
 * @author zrh
 * @version 1.0
 * @date 2020-11-05 15:21
 **/
public class DingTest {
    /**
     * appid
     */
    static final String AGENTID = "951654080";
    /**
     * appkey
     */
    static final String CUSTOM_KEY = "suitedpxwwc9whwxy6duv";
    /**
     * appSecret
     */
    static final String CUSTOM_SECRET = "xAc9TVxejiDjqSRTxE1HC6GafNAC2khF9tPJkFx0Twq9VwtaJbnHj1cmZ7Ggwm84";
    static final String CORP_ID = "dinge276cd0881e4856635c2f4657eb6378f";
    //注意ticket参数是通过dingOne钉钉云接口获取的，且做好缓存 @see http://118.178.91.15/api/dingone/corpInfo?corpId=ding099060891023dbff35c2f4657eb6378f
    static final String ticket = "7PQuh5pHAAKPGzjXJNYRt7IFkeQrqdIER2jBRhJnXsu5g33dxOgjAs2JDhYfahAzukjHTv3jKMEYT0S165PuYW";

    static final String token = "46652e69e86d30a9a5926f648c47569d";

    public static void main(String[] args) throws ApiException {
        outTheForm();

    }

    static String getToken() throws ApiException {
        DefaultDingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/service/get_corp_token");
        OapiServiceGetCorpTokenRequest req = new OapiServiceGetCorpTokenRequest();
        req.setAuthCorpid(CORP_ID);
        OapiServiceGetCorpTokenResponse execute = client.execute(req, CUSTOM_KEY, CUSTOM_SECRET, "suiteTicket");
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

    static void get() throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/edu/group/msg/send");
        OapiEduMainDataGetRequest req = new OapiEduMainDataGetRequest();
        req.setStatDate("20191201");
        OapiEduMainDataGetResponse rsp = client.execute(req, token);
        System.out.println(rsp.getBody());
    }

    static void outTheForm() throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/collection/form/list");
        OapiCollectionFormListRequest req = new OapiCollectionFormListRequest();
       /* req.setBizType(0L);
        req.setCreator("userid");*/
        req.setOffset(0L);
        req.setSize(200L);
        OapiCollectionFormListResponse rsp = client.execute(req, token);
        System.out.println(rsp.getBody());
    }

}
