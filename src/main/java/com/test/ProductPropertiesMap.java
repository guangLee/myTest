package com.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: wangzhx
 * @create: 2019-10-23 17:17
 */
public class ProductPropertiesMap {

    public final static Map<Integer, Integer> productStatusMap = new HashMap<>();
    public final static Map<String, Integer> validTagMap = new HashMap<>();

    static {
        productStatusMap.put(3, 6);
        productStatusMap.put(6, 5);
        productStatusMap.put(9, 4);
        productStatusMap.put(7, 3);
        productStatusMap.put(2, 2);
        productStatusMap.put(0, 1);

        validTagMap.put("0", 3);
        validTagMap.put("2", 2);
        validTagMap.put("1", 1);
    }
}
