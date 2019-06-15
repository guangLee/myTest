package com.thread;
/**
 * Description:
 * 死锁是指两个或者以上的进程在执行过程中,
 * 因争夺资源而造成的一种相互等待的现象,
 * 若无外力干涉那他们都将无法推进下去
 **/
public class DeadLockDemo {

    public static void main(String[] args) {

        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new HoldThread(lockA, lockB), "threadA").start();
        new Thread(new HoldThread(lockB, lockA), "threadB").start();
    }

}
