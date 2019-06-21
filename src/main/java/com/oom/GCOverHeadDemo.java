package com.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * java.lang.OutOfMemoryError: GC overhead limit exceeded
 *实现此报错，需要配置 VM Options: -Xms10m -Xmx10m
 */
public class GCOverHeadDemo {

    public static void main(String[] args) {

        int i = 0;
        List<String> list = new ArrayList<>();

        try {
            while (true) {
                list.add(String.valueOf(++i).intern());
            }
        } catch (Throwable e) {
            System.out.println("**************i: " + i);
            //Exception in thread "main" java.Lang.OutOfMemoryError: GC overhead limit exceeded
            e.printStackTrace();
            throw e;
        }
    }
}
