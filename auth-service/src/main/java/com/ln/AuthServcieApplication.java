package com.ln;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description
 * @Author HeZhipeng
 * @Date 2022/2/27 16:14
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class AuthServcieApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthServcieApplication.class, args);
    }

}
