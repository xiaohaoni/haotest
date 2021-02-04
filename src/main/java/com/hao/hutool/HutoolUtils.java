package com.hao.hutool;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import com.sun.org.glassfish.gmbal.NameValue;
import groovy.util.logging.Slf4j;

import javax.annotation.PostConstruct;

/**
 * 雪花
 *
 * @author zrh
 * @version 1.0
 * @date 2020-12-26 13:38
 **/
@Slf4j
public class HutoolUtils {
    private static final long workerIdBits = 5L;
    // 最大支持机器节点数0~31，一共32个
    //@SuppressWarnings({"PointlessBitwiseExpression", "FieldCanBeLocal"})
    private static final long maxWorkerId = -1L ^ (-1L << workerIdBits);

    public static void main(String[] args) {
        //System.out.println(NetUtil.getLocalhostStr().hashCode());

        System.out.println(showflakeId(31, 31));

    }

    /**
     * 0-31
     */
    private static long workerId = 0;
    /**
     * 0-31
     */
    private static long datacenterId = 1;
    private static Snowflake snowflake = IdUtil.createSnowflake(workerId, datacenterId);

    @PostConstruct
    public void init() {
        try {
            workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
            System.out.println(workerId);
        } catch (Exception e) {
            workerId = NetUtil.getLocalhostStr().hashCode();
            System.out.println(workerId);

        }

    }

    public static synchronized long snowflakeId() {
        return snowflake.nextId();
    }

    /**
     * @param workerId     终端ID
     * @param datacenterId 数据中心ID
     */
    public static synchronized long showflakeId(long datacenterId, long workerId) {
        Snowflake snowflake = IdUtil.createSnowflake(workerId, datacenterId);
        return snowflake.nextId();
    }

}
