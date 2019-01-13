package com.cmg.saien.controller;


import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.common.HttpConfig;
import com.arronlong.httpclientutil.exception.HttpProcessException;
import com.cmg.saien.spider.processor.TestPageProcessor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import us.codecraft.webmagic.Spider;


@RestController
public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {

        long startTime, endTime;
        System.out.println("开始爬取...");
        startTime = System.currentTimeMillis();
        TestPageProcessor ret = new TestPageProcessor();

//         String onlylady= "http://pic.onlylady.com/";
//         String mmonly= "http://www.mmonly.cc/sgtp/";
         String nanrentu= "https://www.nanrentu.cc/sgtp/omsg_1.html";


        Spider.create(ret).addUrl(nanrentu).thread(1).run();
        endTime = System.currentTimeMillis();
        System.out.println("爬取结束，耗时约" + ((endTime - startTime) / 1000) + "秒");
      return ret.getHtml();
    }

    @RequestMapping(value = "/rest", method = RequestMethod.GET)
    public void rest () throws HttpProcessException {

        HttpConfig config = HttpConfig.custom().url("http://wk-p.vemic.com/api/at/getAtDevContent?devId=398");
              /*  .headers(headers)	//设置headers，不需要时则无需设置
                .url(url)	          //设置请求的url
                .map(map)	          //设置请求参数，没有则无需设置
                .encoding("utf-8") //设置请求和返回编码，默认就是Charset.defaultCharset()
                .client(client)    //如果只是简单使用，无需设置，会自动获取默认的一个client对象*/
                //.inenc("utf-8")  //设置请求编码，如果请求返回一直，不需要再单独设置
                //.inenc("utf-8")	//设置返回编码，如果请求返回一直，不需要再单独设置
                //.json("json字符串")                          //json方式请求的话，就不用设置map方法，当然二者可以共用。
                //.context(HttpCookies.custom().getContext()) //设置cookie，用于完成携带cookie的操作
                //.out(new FileOutputStream("保存地址"))       //下载的话，设置这个方法,否则不要设置
                //.files(new String[]{"d:/1.txt","d:/2.txt"}) //上传的话，传递文件路径，一般还需map配置，设置服务器保存路径

        //使用方式：
        String result1 = HttpClientUtil.get(config);     //get请求
        System.out.println(result1);
    }


}
