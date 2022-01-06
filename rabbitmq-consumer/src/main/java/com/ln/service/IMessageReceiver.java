package com.ln.service;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @Description
 * @Author HeZhipeng
 * @Date 2022/1/6 22:51
 **/
public interface IMessageReceiver {

    /**
     * 指定接收的交换器名称
     * @return
     */
    @Input("dpb-exchange")
    SubscribableChannel receiver();



}
