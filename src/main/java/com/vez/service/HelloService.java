package com.vez.service;

import org.springframework.stereotype.Service;

/**
 * @description: some desc
 * @author: wubowen
 * @date: 2021/1/27 0027 14:41
 */
@Service
public class HelloService {
    public String sayHello(String name){
        return "Hello " + name + "!";
    }
}
