package com.ryans.feign;

import com.ryans.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author：Ryans
 * Date：Created in 2023/8/20 16:24
 * Introduction：
 */
@Component
public class UserFeignServiceFallback implements UserFeignService {

    @Override
    public List<User> getUserList() {
        return null;
    }

    @Override
    public User getUser(Long id) {
        User user = new User();
        user.setUsername("用户模块异常");
        return user;
    }
}