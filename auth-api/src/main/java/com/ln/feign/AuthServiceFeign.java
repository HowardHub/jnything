package com.ln.feign;

import com.ln.vo.AuthResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description 授权鉴权 Service 接口
 * @FROM https://www.1024sou.com/article/436968.html
 * @Author HeZhipeng
 * @Date 2022/2/27 16:10
 **/
@FeignClient("auth-service")
// 这里不能用@RequestMapping("/auth")，否则会报错！
public interface AuthServiceFeign {

    /**
     * 登录接口
     * @param userName  用户名
     * @param password  密码
     * @return
     */
    @PostMapping("/auth/login")
    AuthResponse login(@RequestParam("userName") String userName,
                       @RequestParam("password") String password);

    /**
     * 校验token
     * @param token     token
     * @param userName  用户名
     * @return
     */
    @GetMapping("/auth/verify")
    AuthResponse verify(@RequestParam("token") String token,
                        @RequestParam("userName") String userName);

    /**
     * 刷新token
     * @param refreshToken   刷新token
     */
    @PostMapping("/auth/refresh")
    AuthResponse refresh(@RequestParam("refreshToken") String refreshToken);


}
