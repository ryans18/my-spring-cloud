package com.ryans.service.impl;

import com.ryans.entity.User;
import com.ryans.mapper.UserMapper;
import com.ryans.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author：Ryans
 * Date：Created in 2023/8/17 21:38
 * Introduction：
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getListAll() {
        return userMapper.getListAll();
    }

    @Override
    public User getUser(Long id) {
        return userMapper.getUser(id);
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void delete(User user) {

    }
}