package com.vez.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @description: 启动系统任务
 * springboot项目启动的时候会遍历所有的CommandlineRunner实现类并调用其中的run方法
 * @author: wubowen
 * @date: 2021/1/25 0025 14:43
 */

/**
 * 可以通过Order注解对这些实现类进行排序，数字越小越先执行
 */
@Component
@Order(1)
public class MyCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Runner1>>>" + Arrays.toString(args));
    }
}
