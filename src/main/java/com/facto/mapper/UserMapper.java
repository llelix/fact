package com.facto.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.facto.vo.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user where user_name = #{username}")
    List<User> getUserByUsername(String username);
}
