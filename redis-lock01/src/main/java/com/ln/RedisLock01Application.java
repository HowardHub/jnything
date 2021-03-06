package com.ln;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description
 * @Author HeZhipeng
 * @Date 2022/1/3 22:35
 **/
@SpringBootApplication
@EnableEurekaClient
public class RedisLock01Application {


    public static void main(String[] args) {
        SpringApplication.run(RedisLock01Application.class, args);
    }

}
