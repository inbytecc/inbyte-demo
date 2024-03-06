package com.inbyte.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 易思外包后台Demo
 *
 * @author chenjw
 * @date: 2023年11月3日
 */
@EnableScheduling
@SpringBootApplication
public class InbyteAdminDemoApplication {

    private static final Logger log = LoggerFactory.getLogger(InbyteAdminDemoApplication.class);

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        SpringApplication.run(InbyteAdminDemoApplication.class, args);
        log.info("启动成功, 耗时:{}s", (System.currentTimeMillis() - startTime) / 1000);
    }

}
