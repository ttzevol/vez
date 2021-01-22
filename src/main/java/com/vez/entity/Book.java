package com.vez.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description: 实体类，测试application.yml的属性注入
 * @author: wubowen
 * @date: 2021/1/22 0022 13:11
 */
@Data
@Component
@ConfigurationProperties(prefix = "book")
public class Book {
    private String name;
    private String author;
    private List<String> list;
}
