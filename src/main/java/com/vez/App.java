package com.vez;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @description: springboot项目入口类
 * @EnableAutoConfiguration表示开启自动化配置
 * @ComponentScan进行包扫描
 * 可以直接使用@Spring BootApplication代替以下两个注解
 * @author: wubowen
 * @date: 2021/1/22 0022 10:17
 */
@EnableAutoConfiguration
@ComponentScan
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
