package com.ryans;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import com.ryans.config.RandomLoadBalancerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@LoadBalancerClients(@LoadBalancerClient(name = "my-cloud-user",configuration = RandomLoadBalancerConfig.class))
@EnableFeignClients(basePackages = {"com.ryans.feign"})
@EnableHystrix
@EnableHystrixDashboard
public class MyCloudConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyCloudConsumerApplication.class, args);
    }

}
