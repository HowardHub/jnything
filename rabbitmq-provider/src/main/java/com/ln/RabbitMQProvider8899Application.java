package com.ln;

import com.ln.service.IMessageProviderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @Description
 * @Author HeZhipeng
 * @Date 2022/1/6 1:11
 **/
@SpringBootApplication
@EnableBinding(value={IMessageProviderService.class})
public class RabbitMQProvider8899Application {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMQProvider8899Application.class, args);
    }

}
