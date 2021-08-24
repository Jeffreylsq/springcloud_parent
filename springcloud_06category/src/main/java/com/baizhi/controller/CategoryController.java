package com.baizhi.controller;

import com.baizhi.CategoryApplication;
import com.baizhi.feignclient.ProductClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("c")
public class CategoryController {
    Logger log = LoggerFactory.getLogger(CategoryController.class);

    @Value("${server.port}")
    private int port;

    @Autowired
    ProductClient productClient;

    @GetMapping("/list")
    public String test() {
        return "test ok " + port;
    }
    @GetMapping("/category")
    public String category(){
        log.info("进入类别应用。。。。");
        String product = productClient.product();
        String list = productClient.list();
        log.info("result 1:{}", product);
       log.info("result 2:{}", list);
        return "category ok, 当前提供服务端口：" + port;
    }
}
