package com.ryans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Author : Ryans
 * Date : 2023/8/21
 * Introduction :
 */
@SpringBootApplication
@EnableConfigServer
public class MyCloudConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyCloudConfigApplication.class, args);
    }
}
