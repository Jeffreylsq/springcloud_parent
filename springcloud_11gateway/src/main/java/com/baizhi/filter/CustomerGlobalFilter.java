package com.baizhi.filter;

import jdk.nashorn.internal.objects.Global;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * customize Global filter
 */
@Configuration
public class CustomerGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest requets = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        System.out.println("经过全局Filter 处理。。。。");
        Mono<Void> filter = chain.filter(exchange);
        System.out.println("响应回来Filter处理。。。。。");
        return filter;
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
