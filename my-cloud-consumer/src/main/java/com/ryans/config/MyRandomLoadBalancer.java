package com.ryans.config;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.DefaultResponse;
import org.springframework.cloud.client.loadbalancer.EmptyResponse;
import org.springframework.cloud.client.loadbalancer.Request;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.cloud.loadbalancer.core.ReactorServiceInstanceLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Random;

/**
 * Author：Ryans
 * Date：Created in 2023/8/19 0:01
 * Introduction：
 */
public class MyRandomLoadBalancer implements ReactorServiceInstanceLoadBalancer {

    // 服务列表
    private ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSupplierProvider;

    public MyRandomLoadBalancer(ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSupplierProvider) {
        this.serviceInstanceListSupplierProvider = serviceInstanceListSupplierProvider;
    }

    @Override
    public Mono<Response<ServiceInstance>> choose(Request request) {
        ServiceInstanceListSupplier supplier = serviceInstanceListSupplierProvider.getIfAvailable();
        return supplier.get().next().map(this::getInstanceResponse);
    }

    /**
     * 使用随机数获取服务
     * @param instances
     * @return
     */
    private Response<ServiceInstance> getInstanceResponse(
            List<ServiceInstance> instances) {
        System.out.println("进来了");
        if (instances.isEmpty()) {
            return new EmptyResponse();
        }
        System.out.println("进行随机选取服务");
        // 随机算法
        int size = instances.size();
        Random random = new Random();
        ServiceInstance instance = instances.get(random.nextInt(size));

        return new DefaultResponse(instance);
    }

}