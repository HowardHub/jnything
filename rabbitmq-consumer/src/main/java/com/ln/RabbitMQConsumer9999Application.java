package com.ln;

import com.ln.service.IMessageReceiver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @Description
 * @Author HeZhipeng
 * @Date 2022/1/6 22:45
 **/
@SpringBootApplication
@EnableBinding(value = {IMessageReceiver.class})
public class RabbitMQConsumer9999Application {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMQConsumer9999Application.class, args);
    }


}
