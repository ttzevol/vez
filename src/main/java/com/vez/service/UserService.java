package com.vez.service;

import org.springframework.stereotype.Service;

/**
 * @description: 用于测试AOP的一个service类
 * @author: wubowen
 * @date: 2021/1/25 0025 15:02
 */
@Service
public class UserService {
    public String getUserById(Integer id){
        System.out.println("get...");
        return "user";
    }

    public void deleteUserById(Integer id){
        System.out.println("delete...");
    }
}
