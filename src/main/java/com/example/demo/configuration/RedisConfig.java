package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @ClassName RedisConfig
 * @Description TODO
 * @Author feroctiy
 * @Date 2019/8/28 18:38
 * @Version 1.0
 */
@Configuration
public class RedisConfig {

    @Bean
    @Primary
    public <TValue> RedisTemplate< String, TValue > getRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String,TValue> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(RedisSerializer.string());
        redisTemplate.setValueSerializer(RedisSerializer.json());
        redisTemplate.setHashKeySerializer(RedisSerializer.string());
        redisTemplate.setHashValueSerializer(RedisSerializer.json());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

}
