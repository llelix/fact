package com.facto.controller;


import com.facto.service.IMyService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.facto.vo.User;

import java.util.ArrayList;
import java.util.List;

@RestController("/api/v1")
public class MyController {
    private final IMyService myService;

    public MyController(IMyService myService) {
        this.myService = myService;
    }

    @GetMapping("/hello")
    public ResponseEntity MyHello(){

        return ResponseEntity.ok(myService.Hello());
    }
    @GetMapping("/index")
    public String Main(){
        return "index";
    }
    @GetMapping("/user")
    public ResponseEntity Hello(){
        return ResponseEntity.ok(myService.getUsers());
    }

    @GetMapping("/sysUser")
    public String user(Model model){
        List<User> list = myService.getUsers();
        model.addAttribute("userList", list);
        model.addAttribute("sysUser", "SysUser");
        return "sysUser";
    }

}
