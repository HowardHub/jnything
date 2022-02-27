package com.ln.controller;

import com.ln.feign.AuthServiceFeign;
import com.ln.jwt.JwtService;
import com.ln.vo.Account;
import com.ln.vo.AuthResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Description TODO
 * @Author HeZhipeng
 * @Date 2022/2/27 16:23
 **/
@RestController
@Slf4j
public class AuthController implements AuthServiceFeign {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public AuthResponse login(String userName, String password) {
        Account account = Account.builder()
                .userName(userName)
                .build();

        String token = jwtService.token(account);

        account.setToken(token);
        account.setRefreshToken(UUID.randomUUID().toString());

        redisTemplate.opsForValue().set(account.getRefreshToken(), account);

        return AuthResponse.builder()
                .account(account)
                .code(200)  // 200 代表成功
                .build();
    }

    @Override
    public AuthResponse verify(String token, String userName) {
        log.info("verify start");
        boolean isSuccess = jwtService.verify(token, userName);

        log.info("verify result：" + isSuccess);

        return AuthResponse.builder()
                .code(isSuccess ? 200 : -2)     // -2 代表验证不通过
                .build();
    }

    @Override
    public AuthResponse refresh(String refreshToken) {
        Account account = (Account) redisTemplate.opsForValue().get(refreshToken);
        if (account == null) {
            return AuthResponse.builder()
                    .code(-1)       // -1 代表用户未找到
                    .build();
        }

        String newToken = jwtService.token(account);
        account.setToken(newToken);
        account.setRefreshToken(UUID.randomUUID().toString());

        redisTemplate.delete(refreshToken);
        redisTemplate.opsForValue().set(account.getRefreshToken(), account);

        return AuthResponse.builder()
                .account(account)
                .code(200)  // 200 代表成功
                .build();

    }
}
