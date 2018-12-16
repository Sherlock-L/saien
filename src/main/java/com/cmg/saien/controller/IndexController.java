package com.cmg.saien.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class IndexController {

    @RequestMapping(value ="/about",method = RequestMethod.GET)
    public String index(){
        return "It is saien ,one of the cloude-man-god's project";
    }
}
