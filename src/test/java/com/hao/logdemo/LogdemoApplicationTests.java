package com.hao.logdemo;

import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.Supplier;

@SpringBootTest
class LogdemoApplicationTests {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void contextLoads() {
        logger.info("【info】");
        logger.trace("【trace】");
        logger.debug("【debug】");
        logger.warn("【warn】");
        logger.error("【error】");

    }

}
