package com.ln.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.ln.vo.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

import static sun.security.x509.CertificateX509Key.KEY;

/**
 * @Description TODO
 * @Author HeZhipeng
 * @Date 2022/2/27 16:18
 **/
@Slf4j
@Component
public class JwtService {

    private static final String ISSUE = "ln";

    private static final Long TOKEN_EXPIRES = 1 * 24 * 60 * 60 * 1000L;

    /**
     * 获得 token
     *
     * @param account 账户实体
     * @return
     */
    public String token(Account account) {

        log.info("获取token");

        Date now = new Date();

        // 指定算法，KEY是自定义的秘钥
        Algorithm algorithm = Algorithm.HMAC256(KEY);

        // 生成token
        String token = JWT.create()
                .withIssuer(ISSUE) // 发行人，自定义
                .withIssuedAt(now)
                .withExpiresAt(new Date(now.getTime() + TOKEN_EXPIRES)) // 设置token过期时间
                .withClaim("userName", account.getUserName())   // 自定义属性
                .sign(algorithm);

        log.info(account.getUserName() + " token 生成成功");
        return token;
    }

    /**
     * 验证token
     *
     * @param token
     * @param userName
     * @return
     */
    public boolean verify(String token, String userName) {

        log.info("验证token");

        try {
            // 指定算法，KEY是自定义的秘钥
            Algorithm algorithm = Algorithm.HMAC256(KEY);

            // 验证token
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(ISSUE)     // 发行人，自定义
                    .withClaim("userName", userName)   // 自定义属性
                    .build();

            verifier.verify(token);
            return true;
        } catch (Exception ex) {
            log.error("验证失败", ex);
            return false;
        }
    }

}
