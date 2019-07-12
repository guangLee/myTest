package com.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 我们通过使用 CAS，避免线程的上下文切换，
 * 然后呢，使用一个 volatile 的 boolean 变量，保证不会出现可见性问题，
 * 记住，这个 flag 一定要是 volatile 的，
 * 如果不是，可能你的程序运行起来没问题，
 * 但最终一定会出问题，而且面试官会立马鄙视你。
 *
 * 这样就消除了使用 synchronized 导致的上下文切换带来的损耗，性能更好。
 * 相信，如果你面试的时候，这么写，面试官肯定很满意。
 * 但，我们还有性能更好的。
 */
public class ThreadPrintDemo2 {

    static AtomicInteger cxsNum = new AtomicInteger(0);
    static volatile boolean flag = false;

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            for (; 100 > cxsNum.get(); ) {
                if (!flag && (cxsNum.get() == 0 || cxsNum.incrementAndGet() % 2 == 0)) {
                    // 防止打印速度过快导致混乱
                    try { Thread.sleep(100); } catch (InterruptedException e) { }
                    System.out.println(cxsNum.get());
                    flag = true;
                }
            }
        }
        );

        Thread t2 = new Thread(() -> {
            for (; 100 > cxsNum.get(); ) {
                if (flag && (cxsNum.incrementAndGet() % 2 != 0)) {
                    // 防止打印速度过快导致混乱
                    try { Thread.sleep(100); } catch (InterruptedException e) {}
                    System.out.println(cxsNum.get());
                    flag = false;
                }
            }
        }
        );

        t1.start();
        t2.start();
    }
}