package com.lombok;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.BeanUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {


        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(4);
        list.add(5);
        list.add(1);
        list.add(20);

        // 1. 选出list中的最小值
        Optional<Integer> minOptional = list.stream().min(Integer::compareTo);
        minOptional.ifPresent(min -> System.out.println("最小值-{}"+ min));

        // 2. 选出最大值
        Optional<Integer> maxOptional = list.stream().max(Integer::compareTo);
        maxOptional.ifPresent(max -> System.out.println("最大值-{}"+max));

        // 3. 如果有值就返回，否则就返回一个标记
        Optional<Integer> existedOptional = list.stream().filter(elem -> elem > 100)
                .max(Integer::compareTo);
        int result = existedOptional.orElse(-1000);
        System.out.println("过滤结果：{}"+result);



//        Person p = new Person();
//        p.setAge(88);
//        p.setName("张三");
//        p.setIsOnSale(true);
//        p.setIsHidden(true);
//
//        List<Human> humanList = new ArrayList<>();
//
//        Human h2 = new Human();
//        h2.setAge(88);
//        h2.setName("张三");
//        h2.setIsOnSale(true);
//        h2.setIsHidden(true);
//
//        Human h3 = new Human();
//        h3.setAge(88);
//        h3.setName("张三");
//        h3.setIsOnSale(true);
//        h3.setIsHidden(true);
//
//        Human h4 = new Human();
//        h4.setAge(88);
//        h4.setName("张三");
//        h4.setIsOnSale(true);
//        h4.setIsHidden(true);
//
//        Human h5 = new Human();
//        h5.setAge(88);
//        h5.setName("张三");
//        h5.setIsOnSale(true);
//        h5.setIsHidden(true);
//
//        humanList.add(h2);
//        humanList.add(h3);
//        humanList.add(h4);
//        humanList.add(h5);
//
//        p.setHumanList(humanList);
//
//        String strJson = JSONObject.toJSONString(p);
//
//        System.out.println(strJson);
//
//
//
//        try {
//            ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(
//                    new File("d:/Person.txt")));
//            oo.writeObject(p);
//            System.out.println("Person对象序列化成功！");
//            oo.close();
//
//            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
//                    new File("d:/Person.txt")));
//            Person person = (Person) ois.readObject();
//
//            Human h = new Human();
//            BeanUtils.copyProperties(p,h);
//            System.out.println(h);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }
}
