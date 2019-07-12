package com.thread;

/**
 * 两个线程交替打印的第一种实现方式
 * 100输出完以后，不会终止线程
 *
 * 通过 synchronized 同步两个方法，每次只能有一个线程进入，
 * 每打印一个数，就释放锁，
 * 另一个线程进入，拿到锁，打印，
 * 唤醒另一个线程，然后挂起自己。
 * 循环反复，实现了一个最基本的打印功能。
 *
 * 但，如果你这么写，面试官肯定是不满意的。楼主将介绍一种更好的实现。
 */
public class ThreadPrintDemo {

    public static void main(String[] args) {

        ThreadPrintDemo demo2 = new ThreadPrintDemo();
        Thread t1 = new Thread(demo2::print1);
        Thread t2 = new Thread(demo2::print2);
        t1.start();
        t2.start();
    }

    public synchronized void print2() {
        for (int i = 1; i <= 100; i += 2) {
            System.out.println(i);
            this.notify();
            try { this.wait(); } catch (InterruptedException e) { }
        }
    }

    public synchronized void print1() {
        for (int i = 0; i <= 100; i += 2) {
            System.out.println(i);
            this.notify();
            try { this.wait(); } catch (InterruptedException e) { }
        }
    }
}
