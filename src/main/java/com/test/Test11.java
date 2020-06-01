package com.test;

import java.util.*;

public class Test11 {

    private static int x = 0;
    public static int checkReturn() {
        try {
// x 等于 1，此处不返回
            return ++x;
        } finally {
// 返回的结果是 2
            return ++x;
        }
    }

    public static void main(String[] args) {

        System.out.println(checkReturn());

//        Map<String,String> map = new HashMap<>();
//
//        map.put("66","111");
//        map.put("66","222");
//        map.put("88","333");
//
//        String s = map.get("66");
//        System.out.println(s);


//        List<Integer> testList = new ArrayList<>();
//        testList.add(7);
//        testList.add(6);
//        testList.add(9);
////        testList.add(3);
//
//        int temp;
//        for (int i = 0; i < testList.size()-1; i++) {
//            Integer before = ProductPropertiesMap.productStatusMap.get(testList.get(i));
//            Integer after = ProductPropertiesMap.productStatusMap.get(testList.get(i+1));
//            if(before == null || after == null){
//                continue;
//            }
//            if(before > after ){
//                temp = testList.get(i);
//                testList.set(i,testList.get(i+1));
//                testList.set(i+1,temp);
//            }
//        }
//
//        System.out.println(testList.get(testList.size() - 1));

//        int[] numArr = {36,66,16,6,8,9,99,56,68};
//
//        for (int i = 0; i <numArr.length-1 ; i++) {
//            for (int j = 0; j <numArr.length-1-i ; j++) {
//                if(numArr[j]<numArr[j+1]){
//                    temp = numArr[j];
//                    numArr[j] = numArr[j+1];
//                    numArr[j+1] = temp;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(numArr));
    }
}
