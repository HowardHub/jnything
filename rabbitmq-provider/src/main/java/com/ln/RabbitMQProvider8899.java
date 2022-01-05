package com.ln;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

/**
 * @Description
 * @Author HeZhipeng
 * @Date 2022/1/6 1:11
 **/
@SpringBootApplication
@EnableBinding(Source.class)
public class RabbitMQProvider8899 {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMQProvider8899.class, args);
    }

}
