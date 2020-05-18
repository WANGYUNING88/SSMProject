package com.wang;

import com.wang.service.ContentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@SpringBootTest
class ElasticsearchJdApplicationTests {

    @Autowired
    ContentService contentService;

    @Test
    void contextLoads() throws IOException {
//        System.out.println(contentService.parseContent("java"));
        List<Map<String, Object>> list = contentService.searchPage("疯狂Java讲义", 0, 10);
        for (Map<String, Object> stringObjectMap : list) {
            System.out.println(stringObjectMap);
        }
    }

}
