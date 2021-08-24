package com.baizhi;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

import javax.servlet.ServletRegistration;

@SpringBootApplication
//@EnableDiscoveryClient  //注意：默认只要引用discovery client依赖 该注解无须显示声明 自动注册 consul zk nacos
@EnableHystrixDashboard  //为了开启仪表盘
public class HystrixDashApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashApplication.class, args);
    }
}
