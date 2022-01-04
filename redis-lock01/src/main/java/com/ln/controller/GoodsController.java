package com.ln.controller;

import com.ln.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author HeZhipeng
 * @Date 2022/1/4 22:01
 **/
@RestController
@Slf4j
public class GoodsController {


    @Autowired
    private StringRedisTemplate redisTemplate;


    @Value("${server.port}")
    private String serverPort;

    private static final String REDIS_LOCK = "mylock";


    @GetMapping("/buyGoods")
    public String buyGoods() throws Exception {
        String value = UUID.randomUUID().toString() + Thread.currentThread().getName();

        try {
            Boolean flag = redisTemplate.opsForValue().setIfAbsent(REDIS_LOCK, value, 10L, TimeUnit.SECONDS);// 等价于SETNX
            if (!flag) {
                return "抢锁失败";
            }
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
        } finally {
            Jedis jedis = RedisUtils.getJedis();
            String script = "if redis.call(\"get\",KEYS[1]) == ARGV[1]\n" +
                    "then\n" +
                    "    return redis.call(\"del\",KEYS[1])\n" +
                    "else\n" +
                    "    return 0\n" +
                    "end";
            try{
                Object res = jedis.eval(script, Collections.singletonList(REDIS_LOCK), Collections.singletonList(value));
                if ("1".equals(res.toString())) {
                    log.info("---------解锁成功");
                } else {
                    log.info("---------解锁失败");
                }
            }finally {
                if (jedis != null) {
                    jedis.close();
                }
            }
        }

    }

}
