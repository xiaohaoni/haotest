package com.hao.httpTest.hikHttp

import com.alibaba.fastjson.JSON
import org.joda.time.DateTime


class HikTest01 {

    static Integer routePort = 9016;

    static String routeUrl = "211.140.156.254";
    // 秘钥appkey
    static String appKey = "22343511";
    // 秘钥appSecret
    static String appSecret = "8efsJRNoIz29hRMooFRW";

    public static void main(String[] args) {
        String cardNum = "0577431412";
        String body = getCardNumInfo(cardNum)
        //2037-12-31T23:59:59.000+08:00"fb99aed779ff4938aea0ec9182186a00
        List<HikUserInfo> infoList = new ArrayList<>()
        infoList.add(new HikUserInfo(cardNo: "0157571161", personId: "fb99aed779ff4938aea0ec9182186a00"))
        //String body = activationCard(infoList)
        //String body = personOrgList()
        println(body);
    }


    /**
     * 获取卡号信息
     * */
    static String getCardNumInfo(String cardNum) {
        Map bodyMap = [cardNo: cardNum]
        String bodyJSON = JSON.toJSONString(bodyMap)
        String previewURLsApi = "/api/irds/v1/card/cardInfo";
        String result = hikDoPostResult(routeUrl, routePort, appKey, appSecret, previewURLsApi, bodyJSON, null)
        println(result)
        return result
    }

    /**
     * 退卡
     * */
    static String checkOutCardNum(String cardNum, String personId) {
        Map bodyMap = [cardNo: cardNum, personId: personId]
        String bodyJSON = JSON.toJSONString(bodyMap)
        String previewURLsApi = "/api/cis/v1/card/deletion";
        String result = hikDoPostResult(routeUrl, routePort, appKey, appSecret, previewURLsApi, bodyJSON, null)
        println(result)
        return result

    }

    /**
     * 开卡
     * */
    static String activationCard(List<HikUserInfo> userInfoList) {
        Map bodyMap = [startDate: "2021-01-22", endDate: "2037-12-31", cardList: userInfoList]
        String bodyJSON = JSON.toJSONString(bodyMap)
        println("bodyJson这里:" + bodyJSON)
        String previewURLsApi = "/api/cis/v1/card/bindings";
        String result = hikDoPostResult(routeUrl, routePort, appKey, appSecret, previewURLsApi, bodyJSON, null)
        println(result)
        return result
    }

    /**
     * 添加人员信息到海康中
     * */
    static String savePersonToHik() {

    }

    /**
     * 获取人员组织
     * */
    static String personOrgList() {
        Map bodyMap = [pageNo: 1, pageSize: 100]
        String bodyJSON = JSON.toJSONString(bodyMap)
        String previewURLsApi = "/api/resource/v1/org/orgList";
        String result = hikDoPostResult(routeUrl, routePort, appKey, appSecret, previewURLsApi, bodyJSON, null)
        println(result)
        return result
    }

    static class HikUserInfo {
        String cardNo
        String personId
    }

    /**
     *
     * @param routeUrl 服务地址
     * @param routePort 服务端口
     * @param appKey 秘钥appkey
     * @param appSecret 秘钥appSecret
     * @param previewURLsApi 设置接口的URI地址
     * @param body postString String请求体
     * @return
     */
    static String hikDoPostResult(String routeUrl, Integer routePort, String appKey, String appSecret, String previewURLsApi, String body, Map header) {
        //STEP1：设置平台参数，根据实际情况,设置host appkey appsecret 三个参数.
        String url = "${routeUrl}:${routePort}"
        hikDoPostResult(url, appKey, appSecret, previewURLsApi, body, header)
    }

    static String hikDoPostResult(String url, String ak, String sk, String previewURLsApi, String body, Map header) {
        //组装url
        final String ARTEMIS_PATH = "/artemis"
        Map<String, String> path = new HashMap<String, String>(2) {
            {
                put("http://", ARTEMIS_PATH + previewURLsApi)//根据现场环境部署确认是http还是https
            }
        }
        String contentType = "application/json;charset=UTF-8"

        String result = HikArtemisHttpUtil.doPostStringArtemis(url, ak, sk, path, body, null, null, contentType, header)
        result
    }
}
