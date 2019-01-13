package com.cmg.saien.spider.processor;

import com.alibaba.fastjson.JSONObject;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

public class TestPageProcessor implements PageProcessor {

    private String html;


    private Site site = Site.me()
            .setSleepTime(100)
            .setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36");
    @Override
    public void process(Page page) {

        if(page.getHtml() != null) {
                this.setHtml(page.getHtml().get());
            List<Selectable> list=page.getHtml().xpath("//ul[@class='h-piclist']/li").nodes();
            System.out.println(this.getSite().getDomain());
            for (Selectable s : list) {
                String contentlinkUrl =s.xpath("//a/@href").toString();
                System.out.println(contentlinkUrl);
                page.addTargetRequest(contentlinkUrl);
                String title =s.xpath("//a/@title").toString();
                String coverImgUrl  =s.xpath("//a/img/@src").toString();
            }
            System.out.println("page.getTargetRequests():");
            System.out.println(page.getTargetRequests());
        }
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
