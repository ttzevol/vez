package com.vez.controller;

import com.vez.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 用户注册类，测试springboot的AOP集成
 * @author: wubowen
 * @date: 2021/1/25 0025 15:27
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/getUserById")
    public String getUserById(Integer id){
        return userService.getUserById(id);
    }

    @PostMapping("/deleteUserById")
    public void deleteUserById(Integer id){
        userService.deleteUserById(id);
    }
}
