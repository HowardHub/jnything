package com.ln.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ln.entity.User;
import com.ln.mapper.UserMapper;
import com.ln.service.IUserService;
import com.ln.vo.UserQueryVo;
import com.ln.vo.UserVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author HeZhipeng
 * @Date 2022/2/26 21:19
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {



    @Override
    public List<UserVo> listByName(UserQueryVo queryVo) {
        return this.baseMapper.listByName(queryVo);
    }


}
