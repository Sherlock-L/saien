package com.cmg.saien.spider.processor;

import com.alibaba.fastjson.JSONObject;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

public class TestPageProcessor implements PageProcessor {

    private String html;


    private Site site = Site.me()
            .setSleepTime(100)
            .setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36");
    public static final String list = "http://www.jianshu.com";
    @Override
    public void process(Page page) {

        if(page.getHtml() != null) {
                this.setHtml(page.getHtml().get());
        }
//        System.out.println(page.getHtml().get());
//        System.out.println(this.getSite().getDomain());
//        if (page.getUrl().regex(list).match()) {
//            List<Selectable> list=page.getHtml().xpath("//ul[@class=‘article-list thumbnails‘]/li").nodes();
//            for (Selectable s : list) {
//                String title=s.xpath("//div/h4/a/text()").toString();
//                String link=s.xpath("//div/h4").links().toString();
//                JSONObject news = new JSONObject();
//                news.put("title",title);
//                news.put("link",link);
//                System.out.println(news.toJSONString());
//            }
//        }
    }
    @Override
    public Site getSite() {
        return site;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }
}
