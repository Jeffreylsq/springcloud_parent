package com.baizhi.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

        @GetMapping("demo")
        @HystrixCommand(defaultFallback = "defaultFallBack")
        public String demo(Integer id){
           // System.out.println("Demo ok!!!");
            if (id < 0) {
                throw new RuntimeException("id is invalid");
            }
            return "demo ok";
        }

        //自定义的处理
//        public String demoFallback(Integer id) {
//            return "当前活动火爆 请稍后再试";
//        }

        //默认处理方法
        public String defaultFallBack() {
            return "网络连接失败 请重试..";
        }

}
