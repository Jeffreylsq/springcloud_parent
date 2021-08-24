package com.baozhi.controller;

import org.joda.time.Instant;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UserController {
    Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient localBalancerClient;

    @Autowired
    RestTemplate restTemplate;
    @GetMapping("user")
    public String invokeDemo(){
        log.info("User demo");


//        //1.调用订单请求 服务地址 http://localhost:9999/order 接受返回值String类型
//        RestTemplate restTemplate = new RestTemplate();
//        String orderResult = restTemplate.getForObject("Http://localhost:9999/order", String.class);

        //2.使用ribbon组件 + RestTemplate 实现负载均衡 DiscoveryClient, LoadBalanceClient, @LoadBalance
        List<ServiceInstance> serviceInstance = discoveryClient.getInstances("ORDERS");
        serviceInstance.forEach(serviceInstance1 -> { log.info("服务主:{} 端口:{} 地址:{}", serviceInstance1.getHost(), serviceInstance1.getPort(), serviceInstance1.getUri());}
        );

     //   String result = new RestTemplate().getForObject(serviceInstance.get(0).getUri() + "/order", String.class);

        //3.使用loadbalancerClient 进行服务调用
//        ServiceInstance si = localBalancerClient.choose("ORDERS");
//        log.info("服务主:{} 端口:{} 地址:{}", si.getHost(), si.getPort(), si.getUri());
//        String result2 = restTemplate.getForObject(si.getUri() + "/order", String.class);
        // log.info("调用订单成功{}", orderResult);

        //4. @LoadBalanced 注解 作用：可以让对象具有ribbon负载均衡性
        String result = restTemplate.getForObject("http://ORDERS/order", String.class);
        return "调用order服务成功， 结果为" + result;
    }
}
