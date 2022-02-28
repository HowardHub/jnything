package com.ln.filter;

import com.ln.feign.AuthServiceFeign;
import com.ln.vo.AuthResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

/**
 * @Description auth过滤器
 * @Author HeZhipeng
 * @Date 2022/2/27 16:29
 **/
@Component
@Slf4j
public class AuthFilter implements GatewayFilter, Ordered {


    private static final String AUTH = "Authorization";

    private static final String USER_NAME = "userName";

    @Autowired
    private AuthServiceFeign authService;


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("开始验证");

        // 从 header 中得到 token 和 用户名
        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders headers = request.getHeaders();
        String token = headers.getFirst(AUTH);
        String userName = headers.getFirst(USER_NAME);

        ServerHttpResponse response = exchange.getResponse();

        if (StringUtils.isBlank(token)) {
            log.error("token没有找到");
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }

        // 验证用户名
        log.info("执行验证方法");
        AuthResponse resp = authService.verify(token, userName);
        // 异步调用
//        CompletableFuture<AuthResponse> completableFuture = CompletableFuture.supplyAsync
//                (()-> {
//                    return authService.verify(token, userName);
//                });
//        AuthResponse resp = null;
//        try {
//            resp = completableFuture.get();
//        } catch (Exception ex) {
//            log.error("调用验证接口错误", ex);
//        }
        log.info("执行验证方法完毕");

        if (resp == null || resp.getCode() != 200) {
            log.error("无效的token");
            response.setStatusCode(HttpStatus.FORBIDDEN);
            return response.setComplete();
        }

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -100;
    }
}
