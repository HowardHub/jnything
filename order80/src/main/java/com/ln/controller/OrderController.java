package com.ln.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description 超卖压测入口
 * @Author HeZhipeng
 * @Date 2022/1/4 23:17
 **/
@RestController
@Slf4j
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




}
