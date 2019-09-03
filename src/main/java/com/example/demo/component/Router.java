package com.example.demo.component;

import com.example.demo.model.Dog;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

/**
 * @ClassName Router
 * @Description TODO
 * @Author feroctiy
 * @Date 2019/8/15 15:54
 * @Version 1.0
 */
@Component
@ConfigurationProperties(prefix = "router")
public class Router {
    private String user;

    private String name;

    private Map<String,String> data;

    private List<Map<String,String>> lists;

    private Dog dog;

    public Router() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map< String, String > getData() {
        return data;
    }

    public void setData(Map< String, String > data) {
        this.data = data;
    }

    public List< Map< String, String > > getLists() {
        return lists;
    }

    public void setLists(List< Map< String, String > > lists) {
        this.lists = lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
