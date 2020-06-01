package com.loader;

public class TestClassLoader {

    public static void main(String[] args) {

        System.out.println(TestClassLoader.class.getClassLoader());

        try {
            System.out.println(Class.forName("java.util.Arrays").getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
