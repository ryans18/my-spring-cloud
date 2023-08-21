package com.ryans.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.ryans.entity.User;
import com.ryans.feign.UserFeignService;
import com.ryans.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author：Ryans
 * Date：Created in 2023/8/17 22:12
 * Introduction：
 */
@RestController
@RequestMapping("/user")
@DefaultProperties(defaultFallback = "userError")
public class CustomerUserController {

    @Resource
    private RestTemplate restTemplate;
    private static final String REST_URL_PREFIX = "http://my-cloud-user";

    @Autowired
    private UserFeignService userFeignService;
    @GetMapping("/port")
    @HystrixCommand
    public Result port() {
        String url = REST_URL_PREFIX + "/user/port";
        return Result.success(restTemplate.getForObject(url, String.class));
    }

    @GetMapping("/list/all")
//    @HystrixCommand
    public Result<List<User>> getAllUser() {
        String url = REST_URL_PREFIX + "/user/list/all";
        List<User> list = restTemplate.getForObject(url, List.class);
        return Result.data(list);
    }

    @GetMapping("/detail/{id}")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "500")})
//    @HystrixCommand(fallbackMethod = "getUserError")
    public Result<User> getUser(@PathVariable("id") Long userId) {
        if (userId == 1L) {
            throw new RuntimeException("Consumer自身错误");
        }
        String url = REST_URL_PREFIX + "/user/detail/" + userId;
        User user = restTemplate.getForObject(url, User.class);
        return Result.data(user);
    }

    @GetMapping("/detail2/{id}")
    public Result<User> getUser2(@PathVariable("id") Long userId) {
        User user = userFeignService.getUser(userId);
        return Result.data(user);
    }

    public Result<User> getUserError(Long userId) {
        return Result.fail("服务器拥挤，请稍后重试!");
    }

    public Result<User> userError() {
        return Result.fail("服务器拥挤，请稍后重试!");
    }
    @GetMapping("/list/all2")
    public Result<List<User>> getAllUser2() {
        List<User> list = userFeignService.getUserList();
        return Result.data(list);
    }

}