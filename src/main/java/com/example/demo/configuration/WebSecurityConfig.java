package com.example.demo.configuration;

import com.example.demo.interceptor.RedisSessionInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName WebSecurityConfig
 * @Description TODO
 * @Author feroctiy
 * @Date 2019/8/30 10:11
 * @Version 1.0
 */
@Configuration
public class WebSecurityConfig implements WebMvcConfigurer {

    @Bean
    public RedisSessionInterceptor getSessionInterceptor() {
        return new RedisSessionInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getSessionInterceptor()).addPathPatterns("/api/**").excludePathPatterns("/api/login");
    }
}
