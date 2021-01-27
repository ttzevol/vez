package com.vez.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: BOOK类为了Redis的示例
 * 此处必须实现Serializable接口，这样对象才能够被序列化
 * 序列化：将对象转换为可保持或传输的格式的过程
 * @author: wubowen
 * @date: 2021/1/26 0026 11:21
 */
@Data
public class BookForRedis implements Serializable {
    private Integer id;
    private String name;
    private String author;
}
