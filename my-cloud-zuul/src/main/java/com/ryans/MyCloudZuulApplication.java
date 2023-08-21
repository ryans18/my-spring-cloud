package com.ryans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Author：Ryans
 * Date：Created in 2023/8/20 20:35
 * Introduction：
 */
@SpringBootApplication
//@EnableEurekaClient
@EnableZuulProxy
public class MyCloudZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyCloudZuulApplication.class, args);
    }
}