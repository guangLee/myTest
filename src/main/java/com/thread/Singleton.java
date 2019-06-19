package com.thread;

/**
 * 一个线程安全的禁止指令重排的懒汉式单例模式,适用于面试
 * @Author lihg
 */
public class Singleton {

    public static volatile Singleton instance = null;

    private Singleton(){}

    public static Singleton getInstance(){

        if(instance == null){
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
