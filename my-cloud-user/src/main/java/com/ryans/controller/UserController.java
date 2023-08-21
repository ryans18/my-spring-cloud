package com.ryans.controller;

import com.ryans.entity.User;
import com.ryans.result.Result;
import com.ryans.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author：Ryans
 * Date：Created in 2023/8/17 21:01
 * Introduction：
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Value("${server.port}")
    private int port;

    @GetMapping("/list/all")
    public List<User> getAll() {
        List<User> listAll = userService.getListAll();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return listAll;
    }

    @GetMapping("/detail/{id}")
    public User getUser(@PathVariable("id") Long id) {
//        System.out.println(1/0);
        return userService.getUser(id);
    }


    @GetMapping("/port")
    public String port() {
        return "User Provider: " + port;
    }

}