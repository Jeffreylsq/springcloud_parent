package com.baizhi.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value="PRODUCT") //value:用来书写调用服务id
public interface ProductClient {

    @GetMapping("/product/product")
     String product();

    @GetMapping("/product/list")
     String list();
}
