package com.jdk8;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class OptionalStudy {

    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();

        Optional<String> stringOptional = strings.stream().filter(str->str.contains("11")).findFirst();

        if (stringOptional.isPresent()) {
            System.out.println("88888888");
        }


//        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");

//        List<String> strings = Arrays.asList("abc","555");
//
//        System.out.println(strings.stream().filter(str -> !str.isEmpty()).collect(Collectors.joining("|")));

//        StringBuffer category = new StringBuffer();
//        System.out.println("666:"+category+"");

//        Optional<String> opt2 = Optional.of("tt");
//        opt2.ifPresent(str-> System.out.println(str));

//        List<Integer> list =  Arrays.asList(10,20,30);
        //通过reduce方法得到一个Optional类
//        int a =  list.stream().reduce(Integer::sum).orElse(get("a"));
//        int b =  list.stream().reduce(Integer::sum).orElseGet(() -> get("b"));
//        System.out.println("a  "+a);
//        System.out.println("b  "+b);

//        Optional optional = list.stream().filter(i->i==40).findFirst();
//        if (optional.isPresent()) {
//            System.out.println(optional.get());
//        }

//        OptionalStudy optional = new OptionalStudy();
//        optional.exe();
    }

    public void exe() {
        Optional<String> stringOptional = Optional.of("666");
        stringOptional.map(this::run);
    }

    public String run(String str) {
        System.out.println(str);
        return str;
    }
    public static int get(String name){
        System.out.println(name+"执行了方法");
        return 1;
    }

    private static void method1() {
        //创建空对象；
        Optional<String> optStr = Optional.empty();
        String s = "123";
        //根据一个值创建对象
        optStr = Optional.of(s);
        try {
            //如果传入的值为空会立即抛出空指针异常
            optStr = Optional.of(null);
        } catch (NullPointerException e) {
            System.out.println("catch NullPointerException");
        }
        //利用ofNullable方法创建允许对象是null，在获取optional里面的值时返回的是空对象
        optStr = Optional.ofNullable(null);
        //利用ofNullable方法创建允许对象是null，在获取optional里面的值时返回的是空对象
        Optional<String> optStr2 = Optional.ofNullable(null);
        try {
            optStr2.get();
        } catch (NoSuchElementException e) {
            System.out.println("catch  NoSuchElementException  ");
        }

        //filter 在使用Optional.filter的时候不会打印出+号，在filter时会自动过滤掉值为空的Optional
        Optional<String> opt = Optional.ofNullable(null);
        Optional<String> opt2 = Optional.of("tt");
        System.out.println(opt2.isPresent());

        System.out.println(opt.isPresent());
        boolean a = opt.filter(str->{
            System.out.println("+++++++++++++");
            return 1 == str.length();
        }).isPresent();
        System.out.println("------filter  test ----"+a);


        //map方法转换里面的值
        Optional<String> opt3 = Optional.ofNullable(null);
        Optional<Integer> o =  opt3.map(String::length);
    }
}
