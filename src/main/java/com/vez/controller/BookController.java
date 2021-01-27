package com.vez.controller;

import com.vez.entity.Book;
import com.vez.entity.BookForRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: redis示例
 * @author: wubowen
 * @date: 2021/1/26 0026 17:56
 */
@RestController
public class BookController {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @GetMapping("/test1")
    public void test1(){
        //通过StringRedisTemplate获取一个操作对象
        ValueOperations<String, String> ops1 = stringRedisTemplate.opsForValue();
        //存储一条记录
        ops1.set("name", "java");
        //读取一条记录
        String name = ops1.get("name");
        System.out.println(name);
        //通过RedisTemplate获取一个操作对象
        ValueOperations ops2 = redisTemplate.opsForValue();
        BookForRedis bookForRedis = new BookForRedis();
        bookForRedis.setId(1);
        bookForRedis.setAuthor("Linus");
        bookForRedis.setName("C++");
        //存储一条记录
        ops2.set("b1", bookForRedis);
        //读取一条记录
        BookForRedis book = (BookForRedis) ops2.get("b1");
        System.out.println(book);
    }
}
