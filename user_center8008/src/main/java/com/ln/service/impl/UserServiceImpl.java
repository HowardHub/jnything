package com.ln.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ln.entity.User;
import com.ln.mapper.UserMapper;
import com.ln.service.IUserService;
import com.ln.vo.UserQueryVo;
import com.ln.vo.UserVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Void updateUserById1() {
        User user = new User();
        user.setId(1L);
        user.setName("zhansan");
        user.setPassword("456");
        this.baseMapper.updateById(user);
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Void updateUserById2() {

        int i=1/0; // 让方法二执行失败，看看方法1是否回滚
        return null;
    }


}
