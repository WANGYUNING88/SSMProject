package com.wang.controller;

import com.wang.service.ContentService;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class ContentController {
    @Autowired
    private ContentService contentService;

    @GetMapping("/parse/{keyword}")
    @ResponseBody
    public  Boolean parse(@PathVariable("keyword") String keyword) throws IOException {
        System.out.println("解析keyword【"+keyword+"】");
        return contentService.parseContent(keyword);
    }

    @GetMapping("/search/{keyword}/{pageNo}/{pageSize}")
    @ResponseBody
    public List<Map<String,Object>> searchPage(@PathVariable("keyword") String keyword,
                                               @PathVariable("pageNo") int pageNo,
                                               @PathVariable("pageSize") int pageSize) throws IOException{
        System.out.println("搜索keyword【"+keyword+"】");
        return contentService.searchPage(keyword,pageNo,pageSize);
    }


}
