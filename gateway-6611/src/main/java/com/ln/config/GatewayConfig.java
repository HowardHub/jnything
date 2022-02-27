package com.ln.config;

import com.ln.filter.AuthFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;

/**
 * @Description
 * @Author HeZhipeng
 * @Date 2022/2/27 16:55
 **/

@Configuration
public class GatewayConfig {


//    // 配置鉴权过滤器
//    @Bean
//    @Order
//    public RouteLocator myRoutes(RouteLocatorBuilder builder, AuthFilter authFilter) {
//
//        return builder.routes()
//                .route(r -> r.path("/business/**")
//                        .and()
//                        .method(HttpMethod.GET)
//                        .filters(f -> f.stripPrefix(1)
//                                .filter(authFilter)
//
//                        )
//                        .uri("lb://MY-EUREKA-CLIENT"))
//                .build();
//    }

}
