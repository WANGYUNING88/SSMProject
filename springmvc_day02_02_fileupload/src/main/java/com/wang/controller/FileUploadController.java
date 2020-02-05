package com.wang.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/file")
public class FileUploadController {
    /**
     * 传统方式上传文件
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("fileupload1")
    public String fileupload1(HttpServletRequest request) throws Exception {
        System.out.println("文件上传1...");
        //使用filwupload组件完成上传
        //获取上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        System.out.println("【path】："+path);
        //判断路径是否存在
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        //解析request对象，获取上传的文件
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> fileItems = upload.parseRequest(request);
        //遍历
        for (FileItem fileItem : fileItems){
            //判断，当前item对象是否是上传文件项
            if(fileItem.isFormField()){
                //说明普通表单项
            }else{
                //说明上传文件项
                //获取到上传文件的名称
                String name = fileItem.getName();
                //生成一个唯一id
                String s = UUID.randomUUID().toString().replace("-", "");
                name = s + "_" + name;
                //完成文件上传
                fileItem.write(new File(path,name));
                //删除临时文件
                fileItem.delete();
            }
        }
        return "success";
    }

    /**
     * springmvc上传
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("fileupload2")
    public String fileupload2(HttpServletRequest request , MultipartFile upload) throws Exception {
        System.out.println("文件上传2...");
        //使用filwupload组件完成上传
        //获取上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        System.out.println("【path】："+path);
        //判断路径是否存在
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        //说明上传文件项
        //获取上传文件的名称
        String filename = upload.getOriginalFilename();
        //生成一个唯一id
        String uuid = UUID.randomUUID().toString().replace("_", "");
        filename = uuid + "_" + filename;
        upload.transferTo(new File(path,filename));
        return "success";
    }
    /**
     * 跨服务器上传
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("fileupload3")
    public String fileupload3(HttpServletRequest request , MultipartFile upload) throws Exception {
        System.out.println("文件上传3...");
        String path = "http://localhost:9090/fileuploadserver_war_exploded/uploads/";
        //说明上传文件项
        //获取上传文件的名称
        String filename = upload.getOriginalFilename();
        //生成一个唯一id
        String uuid = UUID.randomUUID().toString().replace("_", "");
        filename = uuid + "_" + filename;
        //完成跨服务器上传功能
        return "success";
    }
}
