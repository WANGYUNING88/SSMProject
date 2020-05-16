package com.wang;

import com.alibaba.fastjson.JSON;
import com.wang.pojo.User;
import org.apache.lucene.util.QueryBuilder;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class WangEsApiApplicationTests {

    private static final String INDEX = "request_index";

//    @Autowired
//    @Qualifier("restHighLevelClient")//指定名称
//    private RestHighLevelClient client;

    @Autowired
    private RestHighLevelClient restHighLevelClient;//或者直接使用对应的名称


    //创建索引 Request
    @Test
    void testCreatIndex() throws IOException {
        //1.创建索引请求
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(INDEX);
        //2.(客户端)执行创建请求后，会获取响应
        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        System.out.println(createIndexResponse);
    }

    //获取索引
    @Test
    void testExistIndex() throws IOException {
        GetIndexRequest getIndexRequest = new GetIndexRequest(INDEX);
        boolean exists = restHighLevelClient.indices().exists(getIndexRequest, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    //删除索引
    @Test
    void testDelete() throws IOException {
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest(INDEX);
        AcknowledgedResponse delete = restHighLevelClient.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
        System.out.println(delete.isAcknowledged());
    }

    //添加文档
    @Test
    void testAddDocument() throws IOException {
        //创建一个对象
        User user = new User("王余柠", 23);
        //创建请求
        IndexRequest indexRequest = new IndexRequest(INDEX);

        //规则 put /request_index/_doc/1;
        indexRequest.id("1");
        indexRequest.timeout(TimeValue.timeValueSeconds(1));
        indexRequest.timeout("1s");

        //将我们数据放入请求
        indexRequest.source(JSON.toJSONString(user), XContentType.JSON);

        //客户端发送请求
        IndexResponse index = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);

        System.out.println(index.toString());
    }

    //获取文档是否存在
    @Test
    void testIsExist() throws IOException {
        GetRequest getRequest = new GetRequest(INDEX,"1");
        getRequest.fetchSourceContext(new FetchSourceContext(false));//不获取返回的_sources 的上下文
        getRequest.storedFields("_none_");

        boolean exists = restHighLevelClient.exists(getRequest, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    //获取文档的信息
    @Test
    void testGetDocument() throws IOException {
        GetRequest getRequest = new GetRequest(INDEX,"1");
        GetResponse getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
        System.out.println(getResponse.getSourceAsString());//打印文档内容
        System.out.println(getResponse);//返回的内容和命令执行结果是一样
    }

    //更新文档的信息
    @Test
    void testUpdateDocument() throws IOException {
        UpdateRequest updateRequest = new UpdateRequest(INDEX,"1");
        updateRequest.timeout("3s");

        User user = new User("王余柠java", 23);
        updateRequest.doc(JSON.toJSONString(user),XContentType.JSON);

        UpdateResponse update = restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);

        System.out.println(update);
    }

    //删除文档记录
    @Test
    void testDeleteDocument() throws IOException {
        DeleteRequest deleteRequest = new DeleteRequest(INDEX,"1");
        deleteRequest.timeout("1s");

        DeleteResponse delete = restHighLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);

        System.out.println(delete);
    }

    //特殊的 真实项目一般都会有批量插入
    @Test
    void testBuikRequest() throws IOException{
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("10s");

        //模拟从数据库中获取到的数据list
        List<User> list = new ArrayList<>();
        for (int i = 0 ;i<10;i++){
            list.add(new User("wangyunin"+i,i));
        }

        //批处理请求
        for (int i = 0;i<list.size();i++){

            bulkRequest.add(
                    //批量更新和批量删除，就在这里修改对应的请求就可以了
                    new IndexRequest(INDEX)
                    .id(""+(i+1))
                    .source(JSON.toJSONString(list.get(i)),XContentType.JSON)
            );
        }

        BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(bulk.hasFailures());//是否失败  false:表示成功


    }

    //查询
    //searchRequest 搜索请求
    //SearchSourceBuilder 条件构造
    //HighlightBuilder 高亮构建
    //TermQueryBuilder 精确查询
    //matchAllQueryBuilder 匹配所有
    // xxx QueryBuilder 对应我们刚才看到的命令
    @Test
    void testSearch() throws IOException {
        //创建搜索的请求
        SearchRequest searchRequest = new SearchRequest(INDEX);

        //构造搜素条件
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        //精准匹配 termQuery()
        //匹配所有 matchAllQuery()
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "wangyunin1");
//        MatchAllQueryBuilder matchAllQueryBuilder = QueryBuilders.matchAllQuery();
        searchSourceBuilder.query(termQueryBuilder);

        searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

//        searchSourceBuilder.from();
//        searchSourceBuilder.size();

        searchRequest.source(searchSourceBuilder);

        SearchResponse search = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        System.out.println(JSON.toJSONString(search.getHits()));
        System.out.println("=======================================");

        for (SearchHit hit : search.getHits()) {
            System.out.println(hit.getSourceAsMap());
        }
    }


    //fastjson
    @Test
    void testFastJson(){
        User user = new User("王余柠", 23);
        String string = JSON.toJSONString(user);
        String string1 = JSON.toJSON(user).toString();
        System.out.println(string1);
    }
}
