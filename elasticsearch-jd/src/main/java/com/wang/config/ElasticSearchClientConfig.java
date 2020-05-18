package com.wang.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Spring两个步骤
//1.找到对象
//2.放到Spring中待用

@Configuration  //xml文件
public class ElasticSearchClientConfig {

    //elk
    //等价于 spring配置 <beans id="restHighLevelClient" class="com.wang.config.ElasticSearchClientConfig">
    @Bean
    public RestHighLevelClient restHighLevelClient(){
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost",9200,"http")//也可以是127.0.0.1
//                        new HttpHost("localhost",9201,"http")//如果是集群构建多个
                )
        );
        return client;
    }
}
