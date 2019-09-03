package com.example.demo.configuration;

import com.example.demo.component.AliYun;
import com.example.demo.component.Upload;
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
public class ApplicationConfig {

    @Bean
    public CommandLineRunner setAliYun(AliYun aliYun){ return args -> AliYun.instance = aliYun;};

    @Bean
    public CommandLineRunner setUpload(Upload upload){ return args -> Upload.instance = upload;};
}
