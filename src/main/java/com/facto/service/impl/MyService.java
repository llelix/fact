package com.facto.service.impl;

import cn.hutool.core.io.file.FileReader;
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
        String text=null;
        File file = new File(".\\db");	//fixme	//获取其file对象
        File[] fs = file.listFiles();	//遍历path下的文件和目录，放在File数组中
        for(File f:fs){					//遍历File[]数组
            if(!f.isDirectory());		//若非目录(即文件)
            //读取输入流
            FileReader fileReader=new FileReader(f.getPath());
            // 获取sql脚本初始化数据库
             text += fileReader.readLines()
                    .stream()
                    .map(string -> "<br>" + string + "<br/>")
                    .collect(Collectors.joining());
            //读取输入流
        }


        return "数据库初始化\n"+text;


    }

    @Override
    public List getUsers() {
        QueryWrapper queryWrapper=new QueryWrapper();

        List<User> users = userMapper.selectList(queryWrapper);
        return users;
    }
}
