package com.facto;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.facto.mapper")
public class FactoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FactoApplication.class, args);
    }

}
