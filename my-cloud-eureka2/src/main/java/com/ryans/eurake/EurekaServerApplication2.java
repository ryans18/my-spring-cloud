package com.ryans.eurake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Author：Ryans
 * Date：Created in 2023/8/17 22:53
 * Introduction：
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication2 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication2.class, args);
    }
}