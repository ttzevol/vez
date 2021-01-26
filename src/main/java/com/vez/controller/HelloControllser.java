package com.vez.controller;

import com.vez.entity.Book;
import com.vez.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @description: some desc
 * @author: wubowen
 * @date: 2021/1/22 0022 10:29
 */
@RestController
public class HelloControllser {
    @Autowired
    Book book;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");

    @GetMapping("/hello")
    public Book hello(){
        return book;
    }

    @GetMapping("/user")
    public User user(){
        User user = new User();
        user.setName("小明");
        user.setSex("男");
        user.setAge(17);
        return user;
    }

    @PostMapping("/upload")
    public String upload(MultipartFile uploadFile, HttpServletRequest req){
        //设置上传文件的保存路径为项目运行目录下的uploadFile文件夹，并在文件夹中通过日期对所上传的文件归类保存
        String realPath = req.getSession().getServletContext().getRealPath("/uploadFile/");
        String format = sdf.format(new Date());
        File folder = new File(realPath + format);
        if (!folder.isDirectory()){
            folder.mkdirs();
        }
        //给上传的文件重命名，避免文件重名
        String oldName = uploadFile.getOriginalFilename();
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."), oldName.length());
        try {
            //保存文件
            uploadFile.transferTo(new File(folder, newName));
            //生成上传文件的访问路径
            String filePath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/uploadFile/"
                    + format + newName;
            return filePath;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }

    /**
     * 解决跨域问题
     * value的值表示来自此Url的请求支持跨域
     * maxage探测请求的有效期，这是是1800s
     * allowHeaders表示允许的请求头，*表示所有的请求头都被允许
     */
    @PostMapping("/cross")
    @CrossOrigin(value = "https://local:8080", maxAge = 1800, allowedHeaders = "*")
    public String addBook(String name){
        return "receive" + name;
    }
}
