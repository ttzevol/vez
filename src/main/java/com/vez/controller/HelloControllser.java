package com.vez.controller;

import com.vez.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: some desc
 * @author: wubowen
 * @date: 2021/1/22 0022 10:29
 */
@RestController
public class HelloControllser {
    @Autowired
    Book book;
    @GetMapping("/hello")
    public String hello(){
        return book.toString();
    }
}
