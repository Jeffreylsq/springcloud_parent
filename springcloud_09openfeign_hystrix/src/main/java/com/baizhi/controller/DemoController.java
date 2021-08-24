package com.baizhi.controller;

import com.baizhi.feignclient.HystirxClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private HystirxClient hystirxClient;

    @GetMapping("test")
    public String demo() {
        System.out.println("Test ok");
        String demo = hystirxClient.demo(-1);
        System.out.println("Demo result: " + demo);
        return "test ok";
    }


}
