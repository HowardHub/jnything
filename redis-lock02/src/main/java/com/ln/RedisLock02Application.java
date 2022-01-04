package com.ln;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description
 * @Author HeZhipeng
 * @Date 2022/1/3 22:38
 **/
@SpringBootApplication
@EnableEurekaClient
public class RedisLock02Application {

    public static void main(String[] args){
        SpringApplication.run(RedisLock02Application.class, args);
    }

}
