package com.ln.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
 * @Description jedis配置
 * @Author HeZhipeng
 * @Date 2022/1/3 0:26
 **/
@Configuration
public class JedisConfig {

    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
        return new JedisConnectionFactory();
    }

}
