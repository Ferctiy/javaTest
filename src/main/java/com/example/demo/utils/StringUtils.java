package com.example.demo.utils;

import java.util.Arrays;

/**
 * @ClassName StringUtils
 * @Description TODO
 * @Author feroctiy
 * @Date 2019/8/29 10:19
 * @Version 1.0
 */
public class StringUtils {

    public static boolean isEmpty(String value) {
        return value == null || value.isEmpty() || value.trim().isEmpty();
    }

    public static boolean equals(String src, String... dests) {
        if (!isEmpty(src) && !CollectionUtils.isEmpty(dests)) {
            return Arrays.stream(dests).anyMatch(a -> src.equals(a));
        }
        return false;
    }
}
