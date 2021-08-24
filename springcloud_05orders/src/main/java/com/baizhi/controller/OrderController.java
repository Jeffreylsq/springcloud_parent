package com.baizhi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    Logger log = LoggerFactory.getLogger(OrderController.class);

    @Value("${server.port}")
    private int port;
    @GetMapping("order")
    public String demo() {
        log.info("Order Demo ...");
        return "当前服务order port " + port;
    }
}
