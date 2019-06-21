package com.oom;

/**
 *java 实现栈内存溢出的案例 StackOverflowError
 */
public class StackOverflowErrorDemo {

    public static void main(String[] args) {

        stackOverflowError();
    }

    private static void stackOverflowError(){

        stackOverflowError();
    }
}
