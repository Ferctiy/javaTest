package com.example.demo.service.impl;

import com.example.demo.component.RedisCache;
import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;
import com.example.demo.utils.RedisPrefix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author feroctiy
 * @Date 2019/8/30 9:49
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    HttpServletRequest request;

    @Autowired
    RedisCache<UserModel> userCache;

    @Override
    public Map<String ,Object> login(UserModel model){
        Map<String,Object> data = new HashMap<>();
        if (model.getName() =="1"){
            userCache.setRedisPrefix(RedisPrefix.Other);
            model.setId(String.valueOf(new Random()));
            model.setAge(request.getSession().getId());
            userCache.append(UserModel.class,model);
            data.put("status",200);
            data.put("message","成功");
        }else {
            data.put("status",400);
            data.put("message","失败");
        }
        return data;
    }
}
