package com.facto.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.lang.Console;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.facto.mapper.UserMapper;
import com.facto.service.IMyService;
import com.facto.vo.User;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MyService implements IMyService  {
    private final UserMapper userMapper;

    public MyService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public String Hello() {

        FileUtil.getName("\\db");
        //获取目录下的文件
        List<String> strings = FileUtil.listFileNames(".\\db");
        String text=null;
        for (String string : strings) {
            FileReader fileReader=new FileReader(".\\db\\"+string);
            if(!fileReader.getFile().isDirectory()) {
                // 获取sql脚本初始化数据库
                text += fileReader.readLines()
                        .stream()
                        .map(str -> "<br>" + str + "<br/>")
                        .collect(Collectors.joining());
                //读取输入流
            }
        }
        return "数据库初始化\n"+text;
    }

    @Override
    public List getUsers() {
        QueryWrapper queryWrapper=new QueryWrapper();
        List<User> users = userMapper.selectList(queryWrapper);
        return users;
    }

    @Override
    public int insertUser() {
        return userMapper.insert(new User(null,"lee",18,"123@emailbox"));
    }

}
