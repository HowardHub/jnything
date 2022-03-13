package com.ln.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * kafka生产者【实际上就是一个Controller，用来进行消息生产】
 *
 * @author 有梦想的肥宅
 * @date 2021/10/29
 */
@RestController
public class KafkaProducer {

    private final static String TOPIC_NAME = "topic1"; //topic的名称

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @RequestMapping("/send")
    public void send() {
        //发送功能就一行代码~
        kafkaTemplate.send(TOPIC_NAME, "key", "test message send~" + UUID.randomUUID());
    }
}