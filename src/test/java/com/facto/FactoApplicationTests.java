package com.facto;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.lang.Console;
import cn.hutool.log.dialect.console.ConsoleLog;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class FactoApplicationTests {

    @Test
    void contextLoads() {
        List<String> strings = FileUtil.listFileNames(".\\db");
        String text=null;
        for (String string : strings) {
            FileReader fileReader=new FileReader(".\\db\\"+string);
            // 获取sql脚本初始化数据库
              text += fileReader.readLines()
                    .stream()
                    .map(str -> "<br>" + str + "<br/>")
                    .collect(Collectors.joining());
            //读取输入流
        }

    }



}
