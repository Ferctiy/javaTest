package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.component.AliYun;
import com.example.demo.component.RedisCache;
import com.example.demo.component.Router;
import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;
import com.example.demo.utils.AliPayUtils;
import com.example.demo.utils.RedisPrefix;
import com.example.demo.utils.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DemoApplicationTest {

    @Autowired
    private Router router;

    @Autowired
    private AliPayUtils aliPayUtils;

    @Autowired
    private RedisCache<UserModel> redisUserCache;

    @Autowired
    private UserService userService;

    @Test
    public void contextLoad() {
        System.out.println(JSON.toJSONString(AliYun.instance));
    }

//    @Test
//    public void redisSetTest() {
//        redisUserCache.setRedisPrefix(RedisPrefix.User);
//        UserModel user = new UserModel();
//        user.setId("5");
//        user.setAge("2");
//        user.setName("2");
//        redisUserCache.append(UserModel.class,user);
//    }
//
//    @Test
//    public void redisGetTest() {
//        redisUserCache.setRedisPrefix(RedisPrefix.User);
//       List<UserModel>  list= redisUserCache.getListItems(UserModel.class, a->  StringUtils.equals(a.getId(),"5"));
//        System.out.println("JSON.toJSONString(list) = " + JSON.toJSONString(list));
//    }
//
//    @Test
//    public void loginTest(){
//        UserModel model = new UserModel();
//        model.setName("1");
//        System.out.println("JSON.toJSONString(userService.login(model)) = " + JSON.toJSONString(userService.login(model)));
//    }
}