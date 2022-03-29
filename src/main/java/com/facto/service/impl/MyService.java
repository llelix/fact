package com.facto.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileReader;
import com.facto.mapper.UserMapper;
import com.facto.service.IMyService;
import org.springframework.stereotype.Service;

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


}
