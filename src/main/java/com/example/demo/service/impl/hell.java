package com.example.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.demo.component.AliYun;
import com.example.demo.component.Router;
import com.example.demo.service.hellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName hell
 * @Description TODO
 * @Author feroctiy
 * @Date 2019/8/15 16:26
 * @Version 1.0
 */
@Service
public class hell implements hellService {

    @Autowired
    private Router router;

    @Override
    public String hello() {
//       Map data = Validation.idCardValidate(aliYun.getAppCode());
//        System.out.println("data = " + data);
        System.out.println("aliYun = " + JSON.toJSONString(AliYun.instance));
        return router.getUser();
    }
}
