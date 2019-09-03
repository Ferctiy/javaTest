package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;
import com.example.demo.service.hellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
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
   private hellService dd;

    @Autowired
    private UserService userService;

    @RequestMapping("user")
    public String getUser(){
       String hell = dd.hello();
        return hell;
    }

    @RequestMapping("/login")
    public Map<String,Object> login(UserModel model){

        return userService.login(model);
    }
}
