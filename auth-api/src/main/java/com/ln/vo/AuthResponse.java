package com.ln.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description
 * @Author HeZhipeng
 * @Date 2022/2/27 16:08
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse implements Serializable {

    // 账户
    private Account account;

    // 响应码
    private Integer code;

}
