package com.facto.controller;


import com.facto.service.IMyService;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.facto.entity.User;

import java.util.Collection;

@Api(tags= "hello")
@RestController("/api/v1")
public class MyController {
    private final IMyService myService;

    public MyController(IMyService myService) {
        this.myService = myService;
    }

    @GetMapping("/hello")
    public ResponseEntity MyHello() {

        return ResponseEntity.ok(myService.Hello());
    }

    @GetMapping("/index")
    public String Main() {
        return "index";
    }

    @GetMapping("/isLogin")
    @ResponseBody
    public Object getUserInfo() {
        if (!SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser")) {
            //已登录
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();//获取用户信息

            //获取登录的用户名
            String username = authentication.getName();
            System.out.println("username : " + username);

            //用户的所有权限
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            System.out.println("authorities : " + authorities);


            /**
             * 如果要获取更详细的用户信息可以采用下面这种方法
             */
            //用户的基本信息
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            System.out.println("user : " + user);

            //用户的id
            Integer userId = user.getId();
            System.out.println("userId: " + userId);

            //User其余信息可以用这种方式获取
            //List<Role> roles = user.getRoles();
            //String password = user.getPassword();
            //String username1 = user.getUsername();


            return "已登录账号：" + username;
        } else {
            //未登录
            return "请先登录";
        }


    }
}
