package com.ln.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description
 * @Author HeZhipeng
 * @Date 2022/2/27 16:10
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account implements Serializable {

    // 用户名
    private String userName;

    // token
    private String token;

    // 刷新token
    private String refreshToken;
}
