package com.example.demo.utils;

import java.util.Collection;

/**
 * @ClassName CollectionUtils
 * @Description TODO
 * @Author feroctiy
 * @Date 2019/8/29 18:08
 * @Version 1.0
 */
public class CollectionUtils {

    @SafeVarargs
    public static <T> boolean isEmpty(T... entries) {
        return entries == null || entries.length == 0;
    }

    /**
     * 判断列表是否为空
     *
     * @param collection 列表
     * @param <T>        类型
     * @return 是否
     */
    public static <T> boolean isEmpty(Collection<T> collection) {
        return collection == null || collection.isEmpty();
    }
}
