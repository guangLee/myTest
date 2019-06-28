package com.reference;

/**
 *当内存不足，JVM开始垃圾回收，对于强引用的对象，就算是出现OOM也不会对该对象进行回收，死都不收。
 * 强引用是我们最常见的普通对彖弓I用，只要还有强弓I用指向一个对彖，就能表明对象还“活着”，垃圾收集器不会碰这种对象。Java
 * 中最常见的就是强弓I川，把一个对彖赋给一个引用变量，这个引用变量就是一个强引用。当一个对彖被強弓I川变量引川时，它处于可达
 * 状态，它是不可能被垃圾回收机制回收的，即使该对彖以后永远都不会被用到JVM也不会回收。因此強弓I川是造成Java内存泄漏的卞要
 * 原因之一。
 *
 * 对于一个普通的对象，如果没有其他的出用关系，只要超过了引用的作用域或者显式地将相应（强）引川赋值为null,
 * 一般认为就是可以被垃圾收集的r （当然具体回收时机还是要看垃圾收集策略）。
 */
public class StrongReferenceDemo {

    public static void main(String[] args) {
        //这样定义的默认就是强引用
        Object objl = new Object();

        Object obj2 = objl;
        objl = null;
        System.gc();
        System.out.println(obj2);
    }
}
