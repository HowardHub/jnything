package com.ln;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description spring boot starter test
 * @Author HeZhipeng
 * @Date 2022/2/25 0:12
 **/

@SpringBootTest(classes = {SpringBootStarterPlayApplication.class})
@RunWith(SpringRunner.class)
public class StarterPlayTest {

    @Autowired
    private ThreadPoolExecutor myThreadPool;

    @Test
    public void test(){
        System.out.println("corePoolSize=" + myThreadPool.getCorePoolSize());
    }

}
