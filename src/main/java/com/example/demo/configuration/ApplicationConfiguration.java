package com.example.demo.configuration;

import com.example.demo.component.AliYun;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName ApplicationConfiguration
 * @Description TODO
 * @Author feroctiy
 * @Date 2019/8/30 10:56
 * @Version 1.0
 */
@Configuration
public class ApplicationConfiguration {

    @Bean
    public CommandLineRunner setAliYun(AliYun aliYun){ return args -> AliYun.instance = aliYun;};
}
