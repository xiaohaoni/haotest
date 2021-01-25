package com.hao.httpTest.hikHttp;

import com.alibaba.fastjson.JSONObject;
import com.hikvision.artemis.sdk.ArtemisHttpUtil;
import com.hikvision.artemis.sdk.config.ArtemisConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zrh
 * @version 1.0
 * @date 2021-01-22 11:24
 **/
public class HikHttpDemo {

    public static String GetCameraPreviewURL() {

        /**
         * STEP1：设置平台参数，根据实际情况,设置host appkey appsecret 三个参数.
         */
        // artemis网关服务器ip端口
        ArtemisConfig.host = "211.140.156.254:9016";
        // 秘钥appkey
        ArtemisConfig.appKey = "22343511";
        // 秘钥appSecret
        ArtemisConfig.appSecret = "8efsJRNoIz29hRMooFRW";

        /**
         * STEP2：设置OpenAPI接口的上下文
         */
        final String ARTEMIS_PATH = "/artemis";

        /**
         * STEP3：设置接口的URI地址
         */
        final String previewURLsApi = ARTEMIS_PATH + "/api/irds/v1/card/cardInfo";
        Map<String, String> path = new HashMap<String, String>(2) {
            {
                put("https://", previewURLsApi);//根据现场环境部署确认是http还是https
            }
        };

        /**
         * STEP4：设置参数提交方式
         */
        String contentType = "application/json";

        /**
         * STEP5：组装请求参数
         */
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("cardNo", "0578853380");
        String body = jsonBody.toJSONString();
        /**
         * STEP6：调用接口
         */
        // post请求application/json类型参数
        String result = ArtemisHttpUtil.doPostStringArtemis(path, body, null, null, contentType , null);
        return result;
    }

    public static void main(String[] args) {

    }
}
