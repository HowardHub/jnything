package com.ln.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.google.common.collect.ImmutableMap;
import com.ln.ResourceNotFoundException;
import com.ln.service.IUserService;
import com.ln.vo.UserQueryVo;
import com.ln.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description TODO
 * @Author HeZhipeng
 * @Date 2022/2/26 20:36
 **/
@RestController
@RequestMapping("user")
@Api("用户接口")
public class UserController{

    @Autowired
    private IUserService userService;


    @ApiOperation("根据名字查询用户")
    @PostMapping("/listByName")
    private List<UserVo> listByName(@RequestBody UserQueryVo queryVo){
        double a = 3/0;
        return userService.listByName(queryVo);
    }

    @ApiOperation("根据名字查询用户")
    @PostMapping("/listByName2")
    private List<UserVo> listByName2(@RequestBody UserQueryVo queryVo){
        if (StringUtils.isEmpty(queryVo.getKeywords())) {
            throw new ResourceNotFoundException(ImmutableMap.of("keywords :", "null"));
        }else {
            return userService.listByName(queryVo);
        }

    }


    @ApiOperation("事务验证")
    @GetMapping("/transaction/check")
    private String transactionCheck(){
        userService.updateUserById1();
        userService.updateUserById2();
        return "OK";
    }


}
