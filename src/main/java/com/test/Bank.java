package com.test;

public abstract class Bank {

    public void quhao(){
        System.out.println("取号");
    }

    public void pingjia(){
        System.out.println("评价");
    }

    public abstract void doing();

    public final void liucheng(){
        quhao();
        doing();
        pingjia();
    }

}
