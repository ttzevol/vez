package com.vez.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description: 全局的跨域配置
 * @author: wubowen
 * @date: 2021/1/22 0022 17:12
 */
@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {
    //addMapping表示对哪种格式的请求路径进行处理
    //allowedHeaders表示允许的请求头，默认为所有
    //allowedMethods允许的请求方法，默认是GET,POST,HEAD，*表示所有的请求方法
    //maxAge探测请求有效期
    //allowedOrigins表示支持的域
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .maxAge(1800)
                .allowedOrigins("https://localhost:8088");
    }
}
