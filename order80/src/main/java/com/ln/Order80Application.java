package com.ln;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description
 * @Author HeZhipeng
 * @Date 2022/1/4 23:15
 **/
@SpringBootApplication
@EnableEurekaClient
public class Order80Application {


    public static void main(String[] args) {
        SpringApplication.run(Order80Application.class, args);
    }

}
