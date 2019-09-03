package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author feroctiy
 * @Date 2019/8/15 14:54
 * @Version 1.0
 */
@RestController
//@RequestMapping("api")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public Map<String,Object> login(UserModel model){
        System.out.println(" 登录中。。。。。。。。。。" );
        System.out.println("JSON.toJSONString(model) = " + JSON.toJSONString(model));
        return userService.login(model);
    }
}
