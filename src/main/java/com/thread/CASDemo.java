package com.thread;
/**
 * CAS的全称为Compare-And-Swap ,它是一条CPU并发原语.
 *
 * 它的功能是判断内存某个位置的值是否为预期值,如果是则更新为新的值,这个过程是原子的.
 *
 * CAS并发原语提现在Java语言中就是sun.misc.UnSaffe类中的各个方法.
 *
 * 调用UnSafe类中的CAS方法,JVM会帮我实现CAS汇编指令.这是一种完全依赖于硬件功能,通过它实现了原子操作,
 *
 * 再次强调,由于CAS是一种系统原语,原语属于操作系统用于范畴,
 *
 * 是由若干条指令组成,用于完成某个功能的一个过程,并且原语的执行必须是连续的,
 *
 * 在执行过程中不允许中断,也即是说CAS是一条原子指令,不会造成所谓的数据不一致的问题.
 */

import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo {

    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(5);

        System.out.println(atomicInteger.compareAndSet(5, 2019)+"\t current"+atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 2014)+"\t current"+atomicInteger.get());
    }
}
