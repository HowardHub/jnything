package com.ln.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**z
 * @Description
 * @Author HeZhipeng
 * @Date 2022/2/24 23:59
 **/
@Configuration
public class PlayAutoConfiguration {

    @Bean
    @ConditionalOnClass(ThreadPoolExecutor.class) // 需要项目中存在ThreadPoolExecutor类
    public ThreadPoolExecutor myThreadPool(){
        return new ThreadPoolExecutor(10, 10, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));
    }



}
