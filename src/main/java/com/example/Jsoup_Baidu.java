package com.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.MalformedURLException;
import java.net.URL;

public class Jsoup_Baidu {
    /*
    * 使用Jsoup 访问url
    * 使用Jsoup 根据标签、id、class
    *
    * */
    public static void main(String[] args) throws Exception {
        String url="https://www.baidu.com/";
        // 第一个参数：URL对象（url），第二个参数：延迟时间（单位：毫秒）  jsoup访问延迟，访问30秒内还是没有返回，就超时。
        Document document = Jsoup.parse(new URL(url), 30000);
        /*
        Element element = document.getElementById("s-top-left");
        Elements a = element.getElementsByClass("mnav c-font-normal c-color-t");
        //获取标签内 属性值 使用 Element类里面的attr()  方法内形参是想要获取的标签内的值的属性名。
        //                    text()方法，获取的是文本内容
        for (Element el:a) {
            System.out.println("url:"+el.attr("href")+
                    " ,title:"+el.text());
        }
         */
        Element hotSearch = document.getElementById("hotsearch-content-wrapper");
//        这时候的返回值是 获取到的第0个li标签下的data-index属性值
//        System.out.println(hotSearch.getElementsByTag("li").eq(1).attr("data-index"));
        Elements li = hotSearch.getElementsByTag("li");
        for (Element el:li) {
            System.out.println("index:"+el.attr("data-index")+
                    " ,title:"+el.getElementsByClass("title-content-title").eq(0).text()+
                    " ,url:"+el.getElementsByTag("a").eq(0).attr("href"));
            /*
             * el.getElementsByTag("a").eq(0).attr("href"))
             * 从li标签内拿出来a标签内中的href的值
             *
             * */
        }




    }
}
