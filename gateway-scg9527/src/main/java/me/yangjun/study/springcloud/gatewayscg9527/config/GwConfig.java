package me.yangjun.study.springcloud.gatewayscg9527.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GwConfig {
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        // return builder.routes().route("routeId1", p -> p.path("/provider/user/**").uri("http://localhost:8001")).build();
        return builder.routes().route( p -> p.path("/cnblog").uri("https://www.cnblogs.com/LooYang")).build();
    }
}
