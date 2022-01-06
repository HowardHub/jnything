package com.ln.utils;

import com.ln.service.IMessageProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author HeZhipeng
 * @Date 2022/1/6 22:38
 **/
@Component
public class MessageSendUtil {


    @Autowired
    private IMessageProviderService sendService;


    /**
     * 发送消息
     * @param message
     */
    public void send(String message) {
        // 将需要发送的消息封装为Message对象
        Message msg = MessageBuilder
                .withPayload(message.getBytes())
                .build();
        sendService.send().send(msg);
    }


}
