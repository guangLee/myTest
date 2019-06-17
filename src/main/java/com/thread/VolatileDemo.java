package com.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class VolatileDemo {

    public static void main(String[] args) {

        MyData myData =new MyData();
        for (int i = 1; i <= 20; i++) {
            new Thread(()->{
                for (int j = 1; j <= 1000 ; j++) {
                    myData.addPlus();
                    myData.addAtomic();
                }
            },String.valueOf(i)).start();
        }

        while (Thread.activeCount()>2) {

        }
        System.out.println(Thread.currentThread().getName()+"\t finally number value"+myData.number);
        System.out.println(Thread.currentThread().getName()+"\t finally atomicInteger value"+myData.atomicInteger);
    }

    private static void seeOkByVolatile() {
        MyData myData =new MyData();

        new Thread(()-> {
            System.out.println(Thread.currentThread().getName()+"\t come in!");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName()+"\t updated number value:"+myData.number);
        },"AAA").start();

        while (myData.number == 0) {

        }

        System.out.println(Thread.currentThread().getName()+"\t mission is over,main get number value:"+myData.number);
    }
}

class MyData{
    volatile int number = 0;
    public void addTo60(){
        this.number = 60;
    }
    public void addPlus(){number++;}

    AtomicInteger atomicInteger = new AtomicInteger();
    public void addAtomic(){
        atomicInteger.getAndIncrement();
    }

}
