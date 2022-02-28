package com.ln.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ln.entity.User;
import com.ln.vo.UserQueryVo;
import com.ln.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description
 * @Author HeZhipeng
 * @Date 2022/2/26 20:44
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {

    List<UserVo> listByName(@Param("queryVo")UserQueryVo queryVo);

}
