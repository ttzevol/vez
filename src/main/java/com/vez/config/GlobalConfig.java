package com.vez.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 利用@ControllerAdvice进行全局数据配置
 * @author: wubowen
 * @date: 2021/1/22 0022 16:34
 */
@ControllerAdvice
public class GlobalConfig {
    //value属性表示这条返回数据的key，方法的返回值是返回数据的value
    //此时在任意请求的Controller中，通过方法参数中的Model都可以获取info的数据
    @ModelAttribute(value = "info")
    public Map<String, String> userInfo(){
        HashMap<String, String> map = new HashMap<>();
        map.put("username", "wubowen");
        map.put("gender", "男");
        return map;
    }
}
