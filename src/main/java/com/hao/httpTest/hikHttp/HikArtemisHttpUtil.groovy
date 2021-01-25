package com.hao.httpTest.hikHttp

import com.hikvision.artemis.sdk.Client
import com.hikvision.artemis.sdk.Request
import com.hikvision.artemis.sdk.Response
import com.hikvision.artemis.sdk.constant.Constants
import com.hikvision.artemis.sdk.constant.ContentType
import com.hikvision.artemis.sdk.constant.HttpHeader
import com.hikvision.artemis.sdk.constant.MsgConstants
import com.hikvision.artemis.sdk.enums.Method
import com.hikvision.artemis.sdk.util.MessageDigestUtil
import groovy.util.logging.Slf4j
import org.apache.commons.lang3.StringUtils
import org.apache.http.HttpResponse

/**
 * @author sunnysails* @date 2020/6/11 17:48
 * @version 1.0* @description
 */
@Slf4j
class HikArtemisHttpUtil {

    static String host = "211.140.156.254:9016";
    // 秘钥appkey
    static String appKey = "22343511";
    // 秘钥appSecret
    static String appSecret = "8efsJRNoIz29hRMooFRW";

    //自定义参与签名Header前缀（可选,默认只有"X-Ca-"开头的参与到Header签名）
    //private final static List<String> CUSTOM_HEADERS_TO_SIGN_PREFIX = new ArrayList<String>();

    //调用网关成功的标志,标志位
    private final static String SUCC_PRE = "2"

    //调用网关重定向的标志,标志位
    private final static String REDIRECT_PRE = "3"

    /**
     * get请求
     *
     * @param path artemis配置的get请求的路径 是一个数组长度为1的Hashmap集合，只存一组数据，key为http的请求方式，value为host后面的path路径。
     * @param querys map类型  get请求的url查询参数（url中的query参数,没有就是为空）形如 "?aa=1&&bb=2"形式参数变成map键值对 query.put("aa","1");query.put("bb","2")
     * @param accept 指定客户端能够接收的内容类型，该参数传空时的默认全部类型接受
     * @param contentType 请求的与实体对应的MIME信息，该参数传空时的取默认值
     * @param header
     */
    static String doGetArtemis(String host, String appKey, String appSecret, Map<String, String> path, Map<String, String> querys, String accept, String contentType, Map<String, String> header) {

        /**
         * 根据传入的path获取是请求是http还是https
         */
        String httpSchema = (String) path.keySet().toArray()[0]

        if (httpSchema == null || StringUtils.isEmpty(httpSchema))
            throw new RuntimeException(MsgConstants.HTTP_SCHEMA_ERROR + "httpSchema: " + httpSchema)

        String responseStr = null
        try {
            HashMap<String, String> headers = doHeaders(accept, contentType)
            if (header != null) {
                headers.putAll(header)
            }
            log.info(path.get(httpSchema))
            responseStr = doResponse(httpSchema, host, path, appKey, appSecret, headers, querys)
        } catch (Exception e) {
            log.error("the Artemis GET Request is failed[doGetArtemis]", e)
        }
        return responseStr
    }


    /**
     * get请求
     *
     * @param path artemis配置的get请求的路径 是一个数组长度为1的Hashmap集合，只存一组数据，key为http的请求方式，value为host后面的path路径。
     * @param querys map类型  get请求的url查询参数（url中的query参数,没有就是为空）形如 "?aa=1&&bb=2"形式参数变成map键值对 query.put("aa","1");query.put("bb","2")
     * @param accept 指定客户端能够接收的内容类型，该参数传空时的默认全部类型接受
     * @param contentType 请求的与实体对应的MIME信息，该参数传空时的取默认值
     */
    static String doGetArtemis(String host, String appKey, String appSecret, Map<String, String> path, Map<String, String> querys, String accept, String contentType) {

        /**
         * 根据传入的path获取是请求是http还是https
         */
        String httpSchema = (String) path.keySet().toArray()[0]

        if (httpSchema == null || StringUtils.isEmpty(httpSchema))
            throw new RuntimeException(MsgConstants.HTTP_SCHEMA_ERROR + "httpSchema: " + httpSchema)

        String responseStr = null
        try {
            HashMap<String, String> headers = doHeaders(accept, contentType)

            log.info(path.get(httpSchema))
            responseStr = doResponse(httpSchema, host, path, appKey, appSecret, headers, querys)
        } catch (Exception e) {
            log.error("the Artemis GET Request is failed[doGetArtemis]", e)
        }
        return responseStr
    }

    /**
     *
     * @param path artemis配置的get请求的路径 是一个数组长度为1的Hashmap集合，只存一组数据，key为http的请求方式，value为host后面的path路径。
     * @param querys map类型  get请求的url查询参数（url中的query参数,没有就是为空）形如 "?aa=1&&bb=2"形式参数变成map键值对 query.put("aa","1");query.put("bb","2")
     * @param accept 指定客户端能够接收的内容类型，该参数传空时的默认全部类型接受
     * @param contentType 请求的与实体对应的MIME信息，该参数传空时的取默认值
     * @param header 请求参数有header以map的方式,没有则为null
     * @return GET图片下载类型 HttpResponse类型
     */
    static HttpResponse doGetResponse(String host, String appKey, String appSecret, Map<String, String> path, Map<String, String> querys, String accept, String contentType, Map<String, String> header) {

        /**
         * 根据传入的path获取是请求是http还是https
         */
        String httpSchema = (String) path.keySet().toArray()[0]

        if (httpSchema == null || StringUtils.isEmpty(httpSchema))
            throw new RuntimeException(MsgConstants.HTTP_SCHEMA_ERROR + "httpSchema: " + httpSchema)

        HttpResponse httpResponse = null
        try {
            HashMap<String, String> headers = doHeaders(accept, contentType)
            if (header != null) {
                headers.putAll(header)
            }
            Request request = new Request(Method.GET_RESPONSE, httpSchema + host,
                    path.get(httpSchema), appKey, appSecret, Constants.DEFAULT_TIMEOUT)
            request.setHeaders(headers)

            request.setQuerys(querys)
            //调用服务端
            Response response = Client.execute(request)

            httpResponse = response.getResponse()

        } catch (Exception e) {
            log.error("the Artemis GET Request is failed[doGetArtemis]", e)
        }

        return httpResponse

    }


    /**
     * postForm请求，postForm请求包含query参数和form表单参数
     *
     * @param path artemis配置的get请求的路径 是一个数组长度为1的Hashmap集合，只存一组数据，key为http的请求方式，value为host后面的path路径。
     * @param paramMap Form表单请求的参数，键值对形式的map
     * @param querys map类型  post请求的url查询参数（url中的query参数,没有就是为空）形如 "?aa=1&&bb=2"形式参数变成map键值对 query.put("aa","1");query.put("bb","2")
     * @param accept 指定客户端能够接收的内容类型，该参数传空时的默认全部类型接受
     * @param contentType 请求的与实体对应的MIME信息，该参数传空时的取默认值("application/x-www-form-urlencoded; charset=UTF-8")
     * @param header 请求参数有header以map的方式,没有则为null
     * @return 返回表单post请求,返回字符串类型*
     */
    static String doPostFormArtemis(String host, String appKey, String appSecret, Map<String, String> path, Map<String, String> paramMap, Map<String, String> querys, String accept, String contentType, Map<String, String> header) {
        /**
         * 根据传入的path获取是请求是http还是https
         */
        String httpSchema = (String) path.keySet().toArray()[0]

        if (httpSchema == null || StringUtils.isEmpty(httpSchema))
            throw new RuntimeException(MsgConstants.HTTP_SCHEMA_ERROR + "httpSchema: " + httpSchema)
        String responseStr = null
        try {
            Map<String, String> headers = new HashMap<String, String>()
            //（必填）根据期望的Response内容类型设置
            if (StringUtils.isNotBlank(accept)) {
                headers.put(HttpHeader.HTTP_HEADER_ACCEPT, accept)
            } else {
                headers.put(HttpHeader.HTTP_HEADER_ACCEPT, "*/*")
            }
            //请求的与实体对应的MIME信息
            if (StringUtils.isNotBlank(contentType)) {
                headers.put(HttpHeader.HTTP_HEADER_CONTENT_TYPE, contentType)
            } else {
                headers.put(HttpHeader.HTTP_HEADER_CONTENT_TYPE, ContentType.CONTENT_TYPE_FORM)
            }
            if (header != null) {
                headers.putAll(header)
            }
            responseStr = doResponse(httpSchema, host, path, appKey, appSecret, headers, querys, paramMap)

        } catch (Exception e) {
            log.error("the Artemis PostForm Request is failed[doPostFormArtemis]", e)
        }
        return responseStr
    }


    /**
     * postForm请求，postForm请求包含query参数和form表单参数
     *
     * @param path artemis配置的get请求的路径 是一个数组长度为1的Hashmap集合，只存一组数据，key为http的请求方式，value为host后面的path路径。
     * @param paramMap Form表单请求的参数，键值对形式的map
     * @param querys map类型  post请求的url查询参数（url中的query参数,没有就是为空）形如 "?aa=1&&bb=2"形式参数变成map键值对 query.put("aa","1");query.put("bb","2")
     * @param accept 指定客户端能够接收的内容类型，该参数传空时的默认全部类型接受
     * @param contentType 请求的与实体对应的MIME信息，该参数传空时的取默认值("application/x-www-form-urlencoded; charset=UTF-8")
     * @return 返回表单post请求,返回字符串类型*
     */
    static String doPostFormArtemis(String host, String appKey, String appSecret, Map<String, String> path, Map<String, String> paramMap, Map<String, String> querys, String accept, String contentType) {
        /**
         * 根据传入的path获取是请求是http还是https
         */
        String httpSchema = (String) path.keySet().toArray()[0]

        if (httpSchema == null || StringUtils.isEmpty(httpSchema))
            throw new RuntimeException(MsgConstants.HTTP_SCHEMA_ERROR + "httpSchema: " + httpSchema)
        String responseStr = null
        try {
            Map<String, String> headers = new HashMap<String, String>()
            //（必填）根据期望的Response内容类型设置
            if (StringUtils.isNotBlank(accept)) {
                headers.put(HttpHeader.HTTP_HEADER_ACCEPT, accept)
            } else {
                headers.put(HttpHeader.HTTP_HEADER_ACCEPT, "*/*")
            }
            //请求的与实体对应的MIME信息
            if (StringUtils.isNotBlank(contentType)) {
                headers.put(HttpHeader.HTTP_HEADER_CONTENT_TYPE, contentType)
            } else {
                headers.put(HttpHeader.HTTP_HEADER_CONTENT_TYPE, ContentType.CONTENT_TYPE_FORM)
            }
            responseStr = doResponse(httpSchema, host, path, appKey, appSecret, headers, querys, paramMap)

        } catch (Exception e) {
            log.error("the Artemis PostForm Request is failed[doPostFormArtemis]", e)
        }
        return responseStr
    }

    /**
     * postformImg请求
     */

    /**
     *
     * @param path artemis配置的get请求的路径 是一个数组长度为1的Hashmap集合，只存一组数据，key为http的请求方式，value为host后面的path路径。
     * @param paramMap Form表单请求的参数，键值对形式的map
     * @param querys map类型  post请求的url查询参数（url中的query参数,没有就是为空）形如 "?aa=1&&bb=2"形式参数变成map键值对 query.put("aa","1");query.put("bb","2")
     * @param accept 指定客户端能够接收的内容类型，该参数传空时的默认全部类型接受
     * @param contentType 请求的与实体对应的MIME信息，该参数传空时的取默认值("application/x-www-form-urlencoded; charset=UTF-8")
     * @param header 请求参数有header以map的方式,没有则为null
     * @return POST表单类型图片下载接口  HttpResponse类型
     */
    static HttpResponse doPostFormImgArtemis(String host, String appKey, String appSecret, Map<String, String> path, Map<String, String> paramMap, Map<String, String> querys, String accept, String contentType, Map<String, String> header) {
        /**
         * 根据传入的path获取是请求是http还是https
         */
        String httpSchema = (String) path.keySet().toArray()[0]

        if (httpSchema == null || StringUtils.isEmpty(httpSchema))
            throw new RuntimeException(MsgConstants.HTTP_SCHEMA_ERROR + "httpSchema: " + httpSchema)
        HttpResponse response = null
        try {
            Map<String, String> headers = new HashMap<String, String>()
            //（必填）根据期望的Response内容类型设置
            if (StringUtils.isNotBlank(accept)) {
                headers.put(HttpHeader.HTTP_HEADER_ACCEPT, accept)
            } else {
                headers.put(HttpHeader.HTTP_HEADER_ACCEPT, "*/*")
            }
            //请求的与实体对应的MIME信息
            if (StringUtils.isNotBlank(contentType)) {
                headers.put(HttpHeader.HTTP_HEADER_CONTENT_TYPE, contentType)
            } else {
                headers.put(HttpHeader.HTTP_HEADER_CONTENT_TYPE, ContentType.CONTENT_TYPE_FORM)
            }
            if (header != null) {
                headers.putAll(header)
            }
            Request request = new Request(Method.POST_FORM_RESPONSE, httpSchema + host,
                    path.get(httpSchema), appKey, appSecret, Constants.DEFAULT_TIMEOUT)
            request.setHeaders(headers)
            //postForm请求的query参数
            request.setQuerys(querys)
            //postForm请求的表单参数
            request.setBodys(paramMap)

            //调用服务端
            Response response1 = Client.execute(request)

            response = response1.getResponse()

        } catch (Exception e) {
            log.error("the Artemis PostForm Request is failed[doPostFormImgArtemis]", e)
        }
        return response
    }


    /**
     * postString请求
     *
     * @param path artemis配置的get请求的路径 是一个数组长度为1的Hashmap集合，只存一组数据，key为http的请求方式，value为host后面的path路径。
     * @param body postString String请求体
     * @param querys map类型  post请求的url查询参数（url中的query参数,没有就是为空）形如 "?aa=1&&bb=2"形式参数变成map键值对 query.put("aa","1");query.put("bb","2")
     * @param accept 指定客户端能够接收的内容类型，该参数传空时的默认全部类型接受
     * @param contentType 请求的与实体对应的MIME信息，该参数传空时的取默认值("application/text; charset=UTF-8")
     * @param header header参数,无过没有值为null
     * @return POST json类型接口  返回字符串类型
     */
    static String doPostStringArtemis(String host, String appKey, String appSecret, Map<String, String> path, String body,
                                      Map<String, String> querys, String accept, String contentType, Map<String, String> header) {
        /**
         * 根据传入的path获取是请求是http还是https
         */
        String httpSchema = (String) path.keySet().toArray()[0]

        if (httpSchema == null || StringUtils.isEmpty(httpSchema))
            throw new RuntimeException(MsgConstants.HTTP_SCHEMA_ERROR + "httpSchema: " + httpSchema)
        String responseStr = null
        try {

            HashMap<String, String> headers = doHeaders(accept, contentType)
            if (header != null) {
                headers.putAll(header)
            }
            responseStr = doResponse(httpSchema, host, path, appKey, appSecret, headers, querys, body)

        } catch (Exception e) {
            log.error("the Artemis PostString Request is failed[doPostStringArtemis]", e)
        }
        return responseStr
    }


    /**
     * postString请求
     *
     * @param path artemis配置的get请求的路径 是一个数组长度为1的Hashmap集合，只存一组数据，key为http的请求方式，value为host后面的path路径。
     * @param body postString String请求体
     * @param querys map类型  post请求的url查询参数（url中的query参数,没有就是为空）形如 "?aa=1&&bb=2"形式参数变成map键值对 query.put("aa","1");query.put("bb","2")
     * @param accept 指定客户端能够接收的内容类型，该参数传空时的默认全部类型接受
     * @param contentType 请求的与实体对应的MIME信息，该参数传空时的取默认值("application/text; charset=UTF-8")
     * @return POST json类型接口  返回字符串类型
     */
    static String doPostStringArtemis(String host, String appKey, String appSecret, Map<String, String> path, String body,
                                      Map<String, String> querys, String accept, String contentType) {
        /**
         * 根据传入的path获取是请求是http还是https
         */
        String httpSchema = (String) path.keySet().toArray()[0]

        if (httpSchema == null || StringUtils.isEmpty(httpSchema))
            throw new RuntimeException(MsgConstants.HTTP_SCHEMA_ERROR + "httpSchema: " + httpSchema)
        String responseStr = null
        try {

            HashMap<String, String> headers = doHeaders(accept, contentType)

            responseStr = doResponse(httpSchema, host, path, appKey, appSecret, headers, querys, body)

        } catch (Exception e) {
            log.error("the Artemis PostString Request is failed[doPostStringArtemis]", e)
        }
        return responseStr
    }

    /**
     * postString请求
     *
     * @param path artemis配置的get请求的路径 是一个数组长度为1的Hashmap集合，只存一组数据，key为http的请求方式，value为host后面的path路径。
     * @param body postString String请求体
     * @param querys map类型  post请求的url查询参数（url中的query参数,没有就是为空）形如 "?aa=1&&bb=2"形式参数变成map键值对 query.put("aa","1");query.put("bb","2")
     * @param accept 指定客户端能够接收的内容类型，该参数传空时的默认全部类型接受
     * @param contentType 请求的与实体对应的MIME信息，该参数传空时的取默认值("application/x-www-form-urlencoded; charset=UTF-8")
     * @param header 请求参数有header以map的方式,没有则为null
     * @return POST json请求类型图片下载接口  HttpResponse类型
     */
    static HttpResponse doPostStringImgArtemis(String host, String appKey, String appSecret, Map<String, String> path, String body,
                                               Map<String, String> querys, String accept, String contentType, Map<String, String> header) {
        /**
         * 根据传入的path获取是请求是http还是https
         */
        String httpSchema = (String) path.keySet().toArray()[0]

        if (httpSchema == null || StringUtils.isEmpty(httpSchema))
            throw new RuntimeException(MsgConstants.HTTP_SCHEMA_ERROR + "httpSchema: " + httpSchema)
        HttpResponse responseStr = null
        try {

            HashMap<String, String> headers = doHeaders(accept, contentType)
            if (header != null) {
                headers.putAll(header)
            }
            Request request = new Request(Method.POST_STRING_RESPONSE, httpSchema + host,
                    path.get(httpSchema), appKey, appSecret, Constants.DEFAULT_TIMEOUT)
            request.setHeaders(headers)
            //请求的query
            request.setQuerys(querys)
            //请求的bodyString
            request.setStringBody(body)
            //调用服务端
            Response response = Client.execute(request)

            responseStr = response.getResponse()

        } catch (Exception e) {
            log.error("the Artemis PostString Request is failed[doPostStringArtemis]", e)
        }
        return responseStr
    }

    /**
     * postBytes请求
     *
     * @param path artemis配置的get请求的路径 是一个数组长度为1的Hashmap集合，只存一组数据，key为http的请求方式，value为host后面的path路径。
     * @param bytesBody 请求体，byte字节
     * @param querys map类型  post请求的url查询参数（url中的query参数,没有就是为空）形如 "?aa=1&&bb=2"形式参数变成map键值对 query.put("aa","1");query.put("bb","2")
     * @param accept 指定客户端能够接收的内容类型，该参数传空时的默认全部类型接受
     * @param contentType 请求的与实体对应的MIME信息，该参数传空时的取默认值("application/text; charset=UTF-8")
     */
    static String doPostBytesArtemis(String host, String appKey, String appSecret, Map<String, String> path, byte[] bytesBody, Map<String, String> querys, String accept, String contentType, Map<String, String> header) {
        /**
         * 根据传入的path获取是请求是http还是https
         */
        String httpSchema = (String) path.keySet().toArray()[0]

        if (httpSchema == null || StringUtils.isEmpty(httpSchema))
            throw new RuntimeException(MsgConstants.HTTP_SCHEMA_ERROR + "httpSchema: " + httpSchema)

        String responseStr = null
        try {
            HashMap<String, String> headers = doHeaders(accept, bytesBody, contentType)
            if (header != null) {
                headers.putAll(header)
            }
            Request request = new Request(Method.POST_BYTES, httpSchema + host,
                    path.get(httpSchema), appKey, appSecret, Constants.DEFAULT_TIMEOUT)
            request.setHeaders(headers)
            //请求的query
            request.setQuerys(querys)
            request.setBytesBody(bytesBody)
            //调用服务端
            Response response = Client.execute(request)

            responseStr = getResponseResult(response)
        } catch (Exception e) {
            log.error("the Artemis PostBytes Request is failed[doPostBytesArtemis]", e)
        }
        return responseStr
    }


    /**
     * postBytes请求
     *
     * @param path artemis配置的get请求的路径 是一个数组长度为1的Hashmap集合，只存一组数据，key为http的请求方式，value为host后面的path路径。
     * @param bytesBody 请求体，byte字节
     * @param querys map类型  post请求的url查询参数（url中的query参数,没有就是为空）形如 "?aa=1&&bb=2"形式参数变成map键值对 query.put("aa","1");query.put("bb","2")
     * @param accept 指定客户端能够接收的内容类型，该参数传空时的默认全部类型接受
     * @param contentType 请求的与实体对应的MIME信息，该参数传空时的取默认值("application/text; charset=UTF-8")
     */
    static String doPostBytesArtemis(String host, String appKey, String appSecret, Map<String, String> path, byte[] bytesBody, Map<String, String> querys, String accept, String contentType) {
        /**
         * 根据传入的path获取是请求是http还是https
         */
        String httpSchema = (String) path.keySet().toArray()[0]

        if (httpSchema == null || StringUtils.isEmpty(httpSchema))
            throw new RuntimeException(MsgConstants.HTTP_SCHEMA_ERROR + "httpSchema: " + httpSchema)

        String responseStr = null
        try {
            HashMap<String, String> headers = doHeaders(accept, bytesBody, contentType)
            Request request = new Request(Method.POST_BYTES, httpSchema + host,
                    path.get(httpSchema), appKey, appSecret, Constants.DEFAULT_TIMEOUT)
            request.setHeaders(headers)
            //请求的query
            request.setQuerys(querys)
            request.setBytesBody(bytesBody)
            //调用服务端
            Response response = Client.execute(request)

            responseStr = getResponseResult(response)
        } catch (Exception e) {
            log.error("the Artemis PostBytes Request is failed[doPostBytesArtemis]", e)
        }
        return responseStr
    }


    /**
     * putString请求
     *
     * @param path artemis配置的get请求的路径 是一个数组长度为1的Hashmap集合，只存一组数据，key为http的请求方式，value为host后面的path路径。
     * @param body putString String请求体
     * @param accept 指定客户端能够接收的内容类型，该参数传空时的默认全部类型接受
     * @param contentType 请求的与实体对应的MIME信息，该参数传空时的取默认值("application/text; charset=UTF-8")
     */
    static String doPutStringArtemis(String host, String appKey, String appSecret, Map<String, String> path, String body, String accept, String contentType) {
        /**
         * 根据传入的path获取是请求是http还是https
         */
        String httpSchema = (String) path.keySet().toArray()[0]

        if (httpSchema == null || StringUtils.isEmpty(httpSchema))
            throw new RuntimeException(MsgConstants.HTTP_SCHEMA_ERROR + "httpSchema: " + httpSchema)

        String responseStr = null
        try {
            Map<String, String> headers = new HashMap<String, String>()
            //（必填）根据期望的Response内容类型设置
            if (StringUtils.isNotBlank(accept)) {
                headers.put(HttpHeader.HTTP_HEADER_ACCEPT, accept)
            } else {
                headers.put(HttpHeader.HTTP_HEADER_ACCEPT, "*/*")
            }
            //（可选）Body MD5,服务端会校验Body内容是否被篡改,建议Body非Form表单时添加此Header
            if (StringUtils.isNotBlank(body)) {
                headers.put(HttpHeader.HTTP_HEADER_CONTENT_MD5, MessageDigestUtil.base64AndMD5(body))
            }
            //（POST/PUT请求必选）请求Body内容格式
            if (StringUtils.isNotBlank(contentType)) {
                headers.put(HttpHeader.HTTP_HEADER_CONTENT_TYPE, contentType)
            } else {
                headers.put(HttpHeader.HTTP_HEADER_CONTENT_TYPE, ContentType.CONTENT_TYPE_TEXT)
            }
            Request request = new Request(Method.PUT_STRING, httpSchema + host,
                    path.get(httpSchema), appKey, appSecret, Constants.DEFAULT_TIMEOUT)
            request.setHeaders(headers)
            request.setStringBody(body)

            //调用服务端
            Response response = Client.execute(request)

            responseStr = getResponseResult(response)

        } catch (Exception e) {
            log.error("the Artemis PutString Request is failed[doPutStringArtemis]", e)
        }
        return responseStr
    }

    /**
     * putBytes请求
     *
     * @param path artemis配置的putBytes请求的路径
     * @param bytesBody 请求体，byte字节
     * @param accept 指定客户端能够接收的内容类型，该参数传空时的默认全部类型接受
     * @param contentType 请求的与实体对应的MIME信息，该参数传空时的取默认值("application/text; charset=UTF-8")
     */
    static String doPutBytesArtemis(String host, String appKey, String appSecret, Map<String, String> path, byte[] bytesBody, String accept, String contentType) {

        /**
         * 根据传入的path获取是请求是http还是https
         */
        String httpSchema = (String) path.keySet().toArray()[0]

        if (httpSchema == null || StringUtils.isEmpty(httpSchema))
            throw new RuntimeException(MsgConstants.HTTP_SCHEMA_ERROR + "httpSchema: " + httpSchema)

        String responseStr = null
        try {
            HashMap<String, String> headers = doHeaders(accept, bytesBody, contentType)
            Request request = new Request(Method.PUT_BYTES, httpSchema + host,
                    path.get(httpSchema), appKey, appSecret, Constants.DEFAULT_TIMEOUT)
            request.setHeaders(headers)
            request.setBytesBody(bytesBody)
            //调用服务端
            Response response = Client.execute(request)

            responseStr = getResponseResult(response)
        } catch (Exception e) {
            log.error("the Artemis PutBytes Request is failed[doPutBytesArtemis]", e)
        }
        return responseStr
    }

    /**
     * delete请求
     *
     * @param path artemis配置的get请求的路径 是一个数组长度为1的Hashmap集合，只存一组数据，key为http的请求方式，value为host后面的path路径。
     * @param querys map类型  delete请求的url查询参数（url中的query参数,没有就是为空）形如 "?aa=1&&bb=2"形式参数变成map键值对 query.put("aa","1");query.put("bb","2")
     * @param accept 指定客户端能够接收的内容类型，该参数传空时的默认全部类型接受
     * @param contentType 请求的与实体对应的MIME信息，该参数传空时的取默认值
     */
    static String doDeleteArtemis(String host, String appKey, String appSecret, Map<String, String> path, Map<String, String> querys, String accept, String contentType) {
        /**
         * 根据传入的path获取是请求是http还是https
         */
        String httpSchema = (String) path.keySet().toArray()[0]

        if (httpSchema == null || StringUtils.isEmpty(httpSchema))
            throw new RuntimeException(MsgConstants.HTTP_SCHEMA_ERROR + "httpSchema: " + httpSchema)

        String responseStr = null
        try {
            Map<String, String> headers = new HashMap<String, String>()
            //（必填）根据期望的Response内容类型设置
            if (StringUtils.isNotBlank(accept)) {
                headers.put(HttpHeader.HTTP_HEADER_ACCEPT, accept)
            } else {
                headers.put(HttpHeader.HTTP_HEADER_ACCEPT, "*/*")
            }
            //请求的与实体对应的MIME信息
            if (StringUtils.isNotBlank(contentType)) {
                headers.put(HttpHeader.HTTP_HEADER_CONTENT_TYPE, contentType)
            }
            Request request = new Request(Method.DELETE, httpSchema + host,
                    path.get(httpSchema), appKey, appSecret, Constants.DEFAULT_TIMEOUT)
            request.setHeaders(headers)
            request.setQuerys(querys)
            //调用服务端
            Response response = Client.execute(request)

            responseStr = getResponseResult(response)
        } catch (Exception e) {
            log.error("the Artemis DELETE Request is failed[doDeleteArtemis]", e)
        }
        return responseStr
    }

    private static String doResponse(String httpSchema, String host, Map<String, String> path, String appKey, String appSecret, HashMap<String, String> headers, Map<String, String> querys) {
        String responseStr
        Request request = new Request(Method.GET, httpSchema + host,
                path.get(httpSchema), appKey, appSecret, Constants.DEFAULT_TIMEOUT)
        request.setHeaders(headers)

        request.setQuerys(querys)
        //调用服务端
        Response response = Client.execute(request)
        responseStr = response.getBody()
        responseStr
    }

    private static String doResponse(String httpSchema, String host, Map<String, String> path, String appKey, String appSecret, HashMap<String, String> headers, Map<String, String> querys, String body) {
        String responseStr
        Request request = new Request(Method.POST_STRING, httpSchema + host,
                path.get(httpSchema), appKey, appSecret, Constants.DEFAULT_TIMEOUT)
        request.setHeaders(headers)
        //请求的query
        request.setQuerys(querys)
        //请求的bodyString
        request.setStringBody(body)
        //调用服务端
        Response response = Client.execute(request)

        responseStr = getResponseResult(response)
        responseStr
    }

    private static String doResponse(String httpSchema, String host, Map<String, String> path, String appKey, String appSecret, HashMap<String, String> headers, Map<String, String> querys, Map<String, String> paramMap) {
        String responseStr
        Request request = new Request(Method.POST_FORM, httpSchema + host,
                path.get(httpSchema), appKey, appSecret, Constants.DEFAULT_TIMEOUT)
        request.setHeaders(headers)
        //postForm请求的query参数
        request.setQuerys(querys)
        //postForm请求的表单参数
        request.setBodys(paramMap)

        //调用服务端
        Response response = Client.execute(request)

        responseStr = getResponseResult(response)
        responseStr
    }

    private static HashMap<String, String> doHeaders(String accept, String contentType) {
        Map<String, String> headers = new HashMap<String, String>()
        //（必填）根据期望的Response内容类型设置
        if (StringUtils.isNotBlank(accept)) {
            headers.put(HttpHeader.HTTP_HEADER_ACCEPT, accept)
        } else {
            headers.put(HttpHeader.HTTP_HEADER_ACCEPT, "*/*")
        }
        //请求的与实体对应的MIME信息
        if (StringUtils.isNotBlank(contentType)) {
            headers.put(HttpHeader.HTTP_HEADER_CONTENT_TYPE, contentType)
        } else {
            headers.put(HttpHeader.HTTP_HEADER_CONTENT_TYPE, ContentType.CONTENT_TYPE_TEXT)
        }
        headers
    }

    private static HashMap<String, String> doHeaders(String accept, byte[] bytesBody, String contentType) {
        Map<String, String> headers = new HashMap<String, String>()
        //（必填）根据期望的Response内容类型设置
        if (StringUtils.isNotBlank(accept)) {
            headers.put(HttpHeader.HTTP_HEADER_ACCEPT, accept)
        } else {
            headers.put(HttpHeader.HTTP_HEADER_ACCEPT, "*/*")
        }
        //（可选）Body MD5,服务端会校验Body内容是否被篡改,建议Body非Form表单时添加此Header
        if (bytesBody != null) {
            headers.put(HttpHeader.HTTP_HEADER_CONTENT_MD5, MessageDigestUtil.base64AndMD5(bytesBody))
        }
        //（POST/PUT请求必选）请求Body内容格式
        if (StringUtils.isNotBlank(contentType)) {
            headers.put(HttpHeader.HTTP_HEADER_CONTENT_TYPE, contentType)
        } else {
            headers.put(HttpHeader.HTTP_HEADER_CONTENT_TYPE, ContentType.CONTENT_TYPE_TEXT)
        }
        headers
    }
    /**
     * response 获取body内容
     *
     * @param response
     */
    private static String getResponseResult(Response response) {
        String responseStr = null

        int statusCode = response.getStatusCode()

        if (String.valueOf(statusCode).startsWith(SUCC_PRE) || String.valueOf(statusCode).startsWith(REDIRECT_PRE)) {
//调用Artemis网关成功
            responseStr = response.getBody()
            log.info("the Artemis Request is Success,statusCode:" + statusCode + " SuccessMsg:" + response.getBody())

        } else {
            String msg = response.getErrorMessage()
            responseStr = response.getBody()
            log.error("the Artemis Request is Failed,statusCode:" + statusCode + " errorMsg:" + msg)
        }
        return responseStr
    }
}
