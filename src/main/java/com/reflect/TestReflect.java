package com.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestReflect {

    public TestReflect(){

    }
    private TestReflect(String name){
        System.out.println(name);
    }
    public TestReflect(Integer age,String name){
        System.out.println(age+name);
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        Class<?> class1 = Class.forName("全限定类名");
        Class<?> class2 = new TestReflect().getClass();
//        Class<?> class3 = TestReflect.class;
//        //将打印出全限定类名（包名.类名）
//        System.out.println("类名称   " + class3.getName());

        Constructor<?>[] constructorsArray = class2.getConstructors();
        for (Constructor<?> constructor : constructorsArray) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
        }
//        Object o = constructorsArray[2].newInstance();
//        System.out.println(o);

        Constructor<?>[] declaredConstructors = class2.getDeclaredConstructors();
        System.out.println(declaredConstructors);
        class2.getDeclaredMethods();
    }
}
