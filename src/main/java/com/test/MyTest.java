package com.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import com.util.MyUtil;

public class MyTest {
//    再次测试下
    public static void main(String[] args) {

        MyBank m = new MyBank();
        m.liucheng();

        //StringBuilder s = new StringBuilder();
        //User u = new User();
        //u.setName("22");
        //System.out.println(u.getName());
        //MyUtil.getStrArray("我就试试这个方法").forEach(s-> System.out.println(s));
        //long l = 1529062650561L;
        //
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //try {
        //    System.out.println(sdf.format(new Date(Long.valueOf("gggggggg"))));
        //} catch (Exception e) {
        //    e.printStackTrace();
        //    System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        //}
        //System.out.println(getNum(6));

    }

    public static int getNum(int n){
        if(n <= 2){
            //System.out.println(1);
            return 1;
        }else {
            int ret = getNum(n-1) + getNum(n-2);
            System.out.println(ret);
            return ret;
        }
    }
}
