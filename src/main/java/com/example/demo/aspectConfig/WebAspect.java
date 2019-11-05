package com.example.demo.aspectConfig;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.annotation.Aspect;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName WebAspect
 * @Description TODO
 * @Author feroctiy
 * @Date 2019/9/3 18:10
 * @Version 1.0
 */
//@Aspect
public class WebAspect {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String s1 = "1111";
        String s2 = "1111";
        list.add(s1);
        list.add(s2);
        System.out.println(" = " + JSON.toJSONString(list));

    }
}
