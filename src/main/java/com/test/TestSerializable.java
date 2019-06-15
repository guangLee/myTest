package com.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 通过反序列化的方式，从输入流中强转获得一个新的对象
 */
public class TestSerializable implements Serializable {
//public class TestSerializable {

    private String name;

    public TestSerializable() {
    }

    public TestSerializable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws Exception {

        String filePath = System.getProperty("user.dir") + "/sample.txt";
        TestSerializable t1 = new TestSerializable("张三");
        System.out.println("t1的哈希值:\t"+t1.hashCode());
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(t1);
            outputStream.flush();
            outputStream.close();

            FileInputStream fileInputStream = new FileInputStream(filePath);
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
            TestSerializable t2 = (TestSerializable)inputStream.readObject();
            inputStream.close();

            System.out.println(t2.getName());
            System.out.println("t2的哈希值:\t"+t2.hashCode());
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }
}