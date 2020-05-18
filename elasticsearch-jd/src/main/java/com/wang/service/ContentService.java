package com.wang.service;

import com.alibaba.fastjson.JSON;
import com.wang.common.Commons;
import com.wang.pojo.Content;
import com.wang.util.HtmlParseUtil;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class ContentService {
    @Autowired
    @Qualifier("restHighLevelClient")//指定名称
    private RestHighLevelClient client;

    @Autowired
    private HtmlParseUtil htmlParseUtil;

    //1.解析数据放入es索引中
    public Boolean parseContent(String keyword) throws IOException {
        List<Content> contents = htmlParseUtil.parseJD(keyword);
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("2m");
        for (int i=0 ;i<contents.size();i++){
            bulkRequest.add(new IndexRequest(Commons.INDEX)
            .source(JSON.toJSONString(contents.get(i)), XContentType.JSON)
            );
        }
        BulkResponse bulk = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        return bulk.hasFailures();
    }

    //2.获取到这些数据实现搜索功能
    public List<Map<String,Object>> searchPage(String keyword,int pageNo,int pageSize) throws IOException {
        if (pageNo<=1)
            pageNo = 1;
        //条件搜索
        SearchRequest searchRequest = new SearchRequest(Commons.INDEX);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        //分页
        searchSourceBuilder.from(pageNo);
        searchSourceBuilder.size(pageSize);

        //精准匹配
        TermQueryBuilder termQueryBuilder = new TermQueryBuilder("title",keyword);

        searchSourceBuilder.query(termQueryBuilder);
        searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        //执行搜索
        searchRequest.source(searchSourceBuilder);
        SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);
        List<Map<String,Object>> list = new ArrayList<>();
        for (SearchHit hit : search.getHits()) {
            list.add(hit.getSourceAsMap());
        }
        return list;
    }

}
