package com.facto.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    /**
     * 如果自动跳转到这个页面，说明用户未登录，返回相应的提示即可
     * 如果要支持表单登录，可以在这个方法中判断请求的类型，进而决定返回JSON还是HTML页面
     * @return
     */
    @RequestMapping("/doLogin")
    public Map<String,String> doLogin(){
        Map<String,String> map = new HashMap<>();
        map.put("msg","尚未登录，请先登录");
        map.put("code","10001");
        return map;
    }
}
