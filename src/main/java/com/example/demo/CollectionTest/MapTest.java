package com.example.demo.CollectionTest;

import sun.security.provider.MD5;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @ClassName MapTest
 * @Description TODO
 * @Author feroctiy
 * @Date 2019/9/5 15:34
 * @Version 1.0
 */
public class MapTest {

    public void sortMap(Map<String,Object> map){

        /**
         * 基于hash实现的,键值可以为null，无须，不唯一
         */
        Map<String,Object> data = new HashMap<>();
        for (int i=1;i<100;i++){
            data.put(String.valueOf(i), i+1);
        }

        Map<String,Object> data1 = new HashMap<>();
        data1.put(null,null);
        data1.put("","");

        map.entrySet().stream().forEach(a->{
            System.out.println(" = " + a.getValue());
            System.out.println(" = " + a.getKey());
        });
    }

}
