package com.example.demo.interceptor;

import com.example.demo.component.RedisCache;
import com.example.demo.model.UserModel;
import com.example.demo.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
//        HttpSession session = request.getSession();
//        String sessionId =userCache.getListItem(UserModel.class,a-> StringUtils.equals(a.getAge(),session.getId()));

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,Exception ex){
    }


}
