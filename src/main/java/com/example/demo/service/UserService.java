package com.example.demo.service;

import com.example.demo.model.UserModel;

import java.util.Map;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author feroctiy
 * @Date 2019/8/30 9:49
 * @Version 1.0
 */
public interface UserService {
    Map< String, Object > login(UserModel model);
}
