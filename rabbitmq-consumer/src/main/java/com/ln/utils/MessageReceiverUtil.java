package com.ln.utils;

import com.ln.service.IMessageReceiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author HeZhipeng
 * @Date 2022/1/6 22:54
 **/
@Component
public class MessageReceiverUtil {





    @StreamListener("dpb-exchange")
    public void onReceiver(byte[] msg){

        System.out.println("消费者:"+new String(msg));
    }




}
