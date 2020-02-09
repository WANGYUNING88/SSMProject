package com.wang.ssmtest.controller;

import com.wang.ssmtest.bean.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.wang.ssmtest.utils.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("file")
public class FileController {
    @RequestMapping("upload")
    @ResponseBody
    public Msg upload(@RequestParam("fileName") MultipartFile file) {
        //上传成功或者失败的标志
        Map<String, Object> map = FileUitls.upload(file, ConstUtils.UPLOADPATH, file.getOriginalFilename());
        System.out.println("[ image upload ] : " + map);
        if ((Boolean) map.get("flag")) {
            return Msg.success().add("filename",map.get("filename"));
        } else
            return Msg.fail().add("filename","default");
    }

    @RequestMapping("show")
    public void show(@RequestParam("filename") String filename, HttpServletResponse response) {
        response.setContentType("image/*");
        if(ConstUtils.DEFAULT.equals(filename)){
            filename = ConstUtils.DEFAULTIMAGE;
        }
        //读取本地图片
        File file = new File(ConstUtils.UPLOADPATH + filename);
        if (!file.exists()){
            return;
        }
        //初始化输入流
        FileInputStream inputStream = null;
        //初始化输出流
        ServletOutputStream outputStream = null;
        try {
            //获取文件的输入流
            inputStream = new FileInputStream(file);
            //将输入流中的数据写到数组中
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            //获取response中输出流
            outputStream = response.getOutputStream();
            outputStream.write(bytes);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
