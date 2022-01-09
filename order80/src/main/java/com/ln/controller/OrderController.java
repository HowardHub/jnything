package com.ln.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

/**
 * @Description 超卖压测入口
 * @Author HeZhipeng
 * @Date 2022/1/4 23:17
 **/
@RestController
@Slf4j
@RequestMapping("order")
public class OrderController {


    @Autowired
    private RestTemplate restTemplate;


    private static final String BASE_URL = "http://redis-lock";


    @GetMapping("/buyGoods")
    public String buyGoods(){
        String result = restTemplate.getForObject(BASE_URL + "/buyGoods", String.class);
        log.info("result==" + result);
        return result;
    }


    /**
     * 浏览器输入
     * http://localhost:6611/order/gatewayTest
     * 被gateway转到这个地址
     * @return
     */
    @GetMapping("/gatewayTest")
    public String gatewayTest(){
        String result = "请求被gateway6611转发到order80啦"  + UUID.randomUUID();
        log.info("result==" + result);
        return result;
    }

}
