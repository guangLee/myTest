package com.test;

import java.util.concurrent.TimeUnit;

public class ThreadDemo implements Cloneable{

    public synchronized void  method1(){
        //public  void  method1(){
        //public static synchronized void  method1(){

        System.out.println(this.hashCode()+"\t"+Thread.currentThread().getName()+"\t"+System.currentTimeMillis());
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m1");

    }
    public synchronized void  method2(){

        System.out.println(this.hashCode()+"\t"+Thread.currentThread().getName()+"\t"+System.currentTimeMillis());
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2");
    }
    public static void main(String[] args) {

        ThreadDemo t = new ThreadDemo();
        ThreadDemo t2 = new ThreadDemo();

        new Thread(()->t.method1(),"1").start();
        new Thread(()->t.method2(),"2").start();
        new Thread(()->t2.method2(),"3").start();
    }
}

