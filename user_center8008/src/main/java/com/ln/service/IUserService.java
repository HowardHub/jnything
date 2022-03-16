package com.ln.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ln.entity.User;
import com.ln.vo.UserQueryVo;
import com.ln.vo.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description TODO
 * @Author HeZhipeng
 * @Date 2022/2/26 21:17
 **/
public interface IUserService extends IService<User> {

    List<UserVo> listByName(UserQueryVo queryVo);


    // ---------------验证事务
    Void updateUserById1();

    Void updateUserById2();
    // ---------------验证事务

}
