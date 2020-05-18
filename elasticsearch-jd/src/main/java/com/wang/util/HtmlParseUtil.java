package com.wang.util;

import com.wang.pojo.Content;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
@Component
public class HtmlParseUtil {

    public List<Content> parseJD(String keyword) throws IOException{
        //获取请求 https://search.jd.com/Search?keyword=java
        //前提，需要联网， ajax 不能获取到！ 模拟浏览器
        //支持中文，可以拼接url  在url后面拼上&enc=utf-8
        String url = "https://search.jd.com/Search?keyword="+keyword+"&enc=utf-8";
        //解析网页(jsoup 返回的Document 就是 Document页面对象)
        Document document = Jsoup.parse(new URL(url), 30000);
        //所有js中可以使用的方法，这里都能用
        Element j_goodsList = document.getElementById("J_goodsList");
        //获取所有的li标签
        Elements lis = j_goodsList.getElementsByTag("li");
        //获取元素中的内容
        List<Content> list = new ArrayList<>();
        for (Element li : lis) {
            //关于图片特别多的网站，左右的图片都是延时加载的 source-data-lazy-img
            String img = li.getElementsByTag("img").eq(0).attr("src");
//            String img = li.getElementsByTag("img").eq(0).attr("source-data-lazy-img");
            String price = li.getElementsByClass("p-price").eq(0).text();
            String title = li.getElementsByClass("p-name").eq(0).text();
            list.add(new Content(title,img,price));
        }
        return list;
    }

    public static void main(String[] args) throws IOException {
        List<Content> java = new HtmlParseUtil().parseJD("vue");
        for (Content content : java) {
            System.out.println(content);
        }
    }

}
