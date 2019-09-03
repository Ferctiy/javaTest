package com.example.demo.utils;

/**
 * @ClassName RedisPrefix
 * @Description 前缀
 * @Author feroctiy
 * @Date 2019/8/29 9:10
 * @Version 1.0
 */
public enum RedisPrefix {

    /**
     * 用户
     */
    User("User", "用户信息"),

    /**
     * 其他信息
     */
    Other("Other", "其他信息");

    private String name;
    private String comment;

    RedisPrefix() {
    }

    RedisPrefix(String name, String comment) {
        this.name = name;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public String getComment() {
        return comment;
    }
}
