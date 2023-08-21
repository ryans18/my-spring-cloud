package com.ryans.feign;

import com.ryans.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "my-cloud-user", path = "/user", fallback = UserFeignServiceFallback.class)
public interface UserFeignService {

    // http://my-cloud-user/user/list/all
    @GetMapping("/list/all")
    List<User> getUserList();

    @GetMapping("/detail/{id}")
    User getUser(@PathVariable("id") Long id);
}
