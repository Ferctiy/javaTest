package com.example.demo.CollectionTest;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

import static org.junit.Assert.*;

public class MapTestTest {

    @Test
    public void sortMap() {
    List list1= new ArrayList();
    list1.add(1);
    list1.add(1);
    Set set = new HashSet();
    set.addAll(list1);
    System.out.println("list1 = " + list1.toString());
        System.out.println("list1 = " + set.toString());
    }
}