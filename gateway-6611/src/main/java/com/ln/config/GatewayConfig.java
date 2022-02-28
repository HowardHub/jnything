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


    // 配置鉴权过滤器：将AuthFilter注册到router中
    @Bean
    @Order
    public RouteLocator myRoutes(RouteLocatorBuilder builder, AuthFilter authFilter) {


        return builder.routes()
                .route(r ->
                        // 以/saas/**过来的请求，都要经过AuthFilter的验证。
                        r.path("/saas/**")
                        .and()
                        .method(HttpMethod.POST,HttpMethod.GET)
                        .filters(f -> f.stripPrefix(1) // 去除/saas/前缀
                                .filter(authFilter)
                        )
                        // 验证通过后需要跳转到哪个服务。。
                        .uri("lb://user-center"))
                .build();
    }

}
