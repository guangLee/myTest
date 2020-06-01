package com.fork;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class ForkJoinWorkDemo {

    public static void main(String[] args) {

        test();
    }


    public static void test() {
        //ForkJoin实现
        long l = System.currentTimeMillis();
        //实现ForkJoin 就必须有ForkJoinPool的支持
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        //参数为起始值与结束值
        ForkJoinTask<Long> task = new ForkJoinWork(0L, 10000000000L);
        Long invoke = forkJoinPool.invoke(task);
        long l1 = System.currentTimeMillis();
        System.out.println("invoke = " + invoke + "  time: " + (l1 - l));
        //invoke = -5340232216128654848  time: 76474
    }

    public void test2() {
        //普通线程实现
        Long x = 0L;
        Long y = 10000000000L;
        long l = System.currentTimeMillis();
        for (Long i = 0L; i <= y; i++) {
            x += i;
        }
        long l1 = System.currentTimeMillis();
        System.out.println("invoke = " + x + "  time: " + (l1 - l));
        //invoke = -5340232216128654848  time: 160939
    }

    public void test3() {
        //Java 8 并行流的实现
        long l = System.currentTimeMillis();
        long reduce = LongStream.rangeClosed(0, 10000000000L).parallel().reduce(0, Long::sum);
        long l1 = System.currentTimeMillis();
        System.out.println("invoke = " + reduce + "  time: " + (l1 - l));
        //invoke = -5340232216128654848  time: 15531
    }

}
