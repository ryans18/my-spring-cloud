package com.ryans.service;

import com.ryans.entity.User;

import java.util.List;

/**
 * Author：Ryans
 * Date：Created in 2023/8/17 21:02
 * Introduction：
 */
public interface UserService {

    List<User> getListAll();
    User getUser(Long id);
    void save(User user);
    void delete(User user);
}