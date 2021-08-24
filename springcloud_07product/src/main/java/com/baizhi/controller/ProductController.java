package com.baizhi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("product")
public class ProductController {
    Logger log = LoggerFactory.getLogger(ProductController.class);

    @Value("${server.port}")
    private int port;
    @GetMapping("/product")
    public String product(){
        log.info("进入商品应用。。。。");
        return "product ok, 当前提供服务端口：" + port;
    }

    @GetMapping("/list")
    public String list(HttpServletRequest request, String color){
        String header = request.getHeader("User-Name");
        System.out.println("Header: " + header);
        System.out.println("Color: " + color);
        return "list info: " + port;
    }


}
