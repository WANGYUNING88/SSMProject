package com.wang.ssmtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.wang.ssmtest.utils.*;

@Controller
@RequestMapping("file")
public class FileController {
    @RequestMapping("upload")
    public void upload(@RequestParam("fileName") MultipartFile file) {
        //上传成功或者失败的标志
        boolean flag = FileUitls.upload(file, ConstUtils.UPLOADPATH, file.getOriginalFilename());
        System.out.println("[ image upload ]："+flag);
    }
}
