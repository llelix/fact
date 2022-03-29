package com.facto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.facto.mapper.UserMapper;
import com.facto.service.UserService;
import com.facto.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService, UserDetailsService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Map<String,Object> map = new HashMap<>();
        map.put("username",s);

        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);

        //注意这里必须保证数据库的用户名唯一
        if(users.size() == 0 || users.get(0) == null){
            System.out.println("用户为null");
            //避免返回null，这里返回一个不含有任何值的User对象，在后期的密码比对过程中一样会验证失败
            return new User();
        }

        return users.get(0);
    }

    //根据id查询用户
    public User selectById(Integer id){
        return userMapper.selectById(id);
    }
}
