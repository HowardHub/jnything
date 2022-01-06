package com.ln.service;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

/**
 * @Description
 * @Author HeZhipeng
 * @Date 2022/1/6 22:36
 **/
public interface IMessageProviderService {

    /**
     * 指定输出的交换器名称
     * @return
     */
    @Output("dpb-exchange")
    SubscribableChannel send();


}
