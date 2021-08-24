package com.baizhi.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        //@formatter:off
//        return builder.routes()
//                .route("path_route", r -> r.path("/category")
//                        .uri("http://localhost:8787/"))
//                .route("path_route_1", r -> r.path("/list")
//                        .uri("http://localhost:8788/"))
//
//                .build();
//        //@formatter:on
//    }
}
