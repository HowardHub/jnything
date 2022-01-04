package com.ln;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author HeZhipeng
 * @Date 2022/1/4 22:12
 **/

@RestController
@Slf4j
public class GoodsController {


    @Autowired
    private StringRedisTemplate redisTemplate;


    @Value("${server.port}")
    private String serverPort;


    @GetMapping("/buyGoods")
    public String buyGoods() {
        synchronized (this) {
            String result = redisTemplate.opsForValue().get("goods:001");// get(key) ==> 看看库存够不够
            int goodsNumber = result == null ? 0 : Integer.parseInt(result);

            if (goodsNumber > 0) {
                int realNumber = goodsNumber - 1;
                redisTemplate.opsForValue().set("goods:001", String.valueOf(realNumber));
                log.info(String.format("从【%s端口】成功买到一个商品，库存还剩下%d件", serverPort, realNumber));
                return String.format("从【%s端口】成功买到一个商品，库存还剩下%d件", serverPort, realNumber);
            } else {
                return "商品已经售完.......+ 服务提供端口：" + serverPort;
            }
        }
    }


}
