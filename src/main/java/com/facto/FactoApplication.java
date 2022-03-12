package com.facto;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;


@SpringBootApplication
@EnableOpenApi
@MapperScan("com.facto.mapper")
public class FactoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FactoApplication.class, args);
    }

}
