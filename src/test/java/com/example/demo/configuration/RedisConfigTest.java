package com.example.demo.configuration;

import com.alibaba.fastjson.JSON;
import com.example.demo.utils.CollectionUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class RedisConfigTest {

    @Test
    public void testJava(){
//        List<String> list = new ArrayList<>();
//        String s1 = "1111";
//        String s2 = "1111";
//        list.add(s1);
//        list.add(s2);
//        System.out.println("s2.hashCode() = " + s1.hashCode());
//        System.out.println("s2.hashCode() = " + s2.hashCode());
//        System.out.println(" = " + JSON.toJSONString(list));
//        Set<String> set = new HashSet<>();
//        set.add(s1);
//        set.add(s2);
//        System.out.println("JSON.toJSONString(set) = " + JSON.toJSONString(set));
        String str = "sj,hds,jU";
        String str1 ="1";
        String str2 = new String("1");
        System.out.println(str.toLowerCase());
        System.out.println(str.toUpperCase());
        System.out.println(str1.isEmpty());
        System.out.println(str1.equals(str2));
        System.out.println(str1==str2);
        System.out.println(str.indexOf("d"));
        System.out.println(str.lastIndexOf("d"));
        System.out.println(str.substring(0,str.lastIndexOf("s")) );
        System.out.println("str2.split() = " + JSON.toJSONString(str.split(",")));
    }

}