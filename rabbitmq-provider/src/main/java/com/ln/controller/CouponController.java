package com.ln.controller;

import com.ln.utils.MessageSendUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Description TODO
 * @Author HeZhipeng
 * @Date 2022/1/6 1:12
 **/

@RestController
@Slf4j
public class CouponController {

    @Autowired
    private MessageSendUtil messageSendUtil;


//
//    private static final Random RANDOM = new Random(System.currentTimeMillis());
//
//    private static final String[] data = new String[] {
//            "abc1", "def1", "qux1",
//            "abc2", "def2", "qux2",
//            "abc3", "def3", "qux3",
//            "abc4", "def4", "qux4",
//    };


    @GetMapping("/createOrder")
    public String createOrder() {
        String msg = "订单号:" + UUID.randomUUID().toString();
        log.info("生产者：" + msg);
        messageSendUtil.send(msg);
        return "创建成功" + msg;
    }

//
//    @InboundChannelAdapter(channel = Source.OUTPUT, poller = @Poller(fixedRate = "5000"))
//    public Message<?> generate() {
//        String value = data[RANDOM.nextInt(data.length)];
//        System.out.println("Sending: " + value);
//        return MessageBuilder.withPayload(value)
//                .setHeader("partitionKey", value)
//                .build();
//    }


}
