package com.example.demo.interceptor;

import com.example.demo.component.RedisCache;
import com.example.demo.model.UserModel;
import com.example.demo.utils.RedisPrefix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * @ClassName RedisSessionInterceptor
 * @Description TODO
 * @Author feroctiy
 * @Date 2019/8/30 10:09
 * @Version 1.0
 */
@Configuration
public class RedisSessionInterceptor implements HandlerInterceptor {

    @Autowired
    RedisCache< UserModel > userCache;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        userCache.setRedisPrefix(RedisPrefix.User);
        Optional< UserModel > userModel = userCache.getListItem(UserModel.class, a -> a.getId().equals(a.getId()));
        System.out.println("前置处理 ");
        return userModel.get().getName().equals(2);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        System.out.println("中间处理");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println("后置处理");
    }


}
