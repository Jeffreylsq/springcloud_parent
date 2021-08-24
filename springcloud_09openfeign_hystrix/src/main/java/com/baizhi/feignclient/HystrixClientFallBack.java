package com.baizhi.feignclient;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallBack implements HystirxClient {

    @Override
    public String demo(Integer id) {
        return id + "当前服务不可用请稍后再试";
    }
}
