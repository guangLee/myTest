package com.test;
import java.util.Arrays;

/**
 * 冒泡排序，哈哈，还得深挖一下
 * 嵌套for循环
 * 里层for循环为了把交换后的值移动到右边去，
 *
 * 如果是从大到小排序，
 * 里层for第一次执行后，就会得出一个最小值，并把最小值放到最右
 * 第二次执行后，就会得出一个第二最小值，并把最小值放到第二右
 * 以此类推，最后一次执行后，就会得出一个最大值，然后把最大值放到最左边
 *
 * 从小到大排序，也是这个原理的
 *
 * 外层for循环是为了控制循环的次数，保证每个元素都会被 比较交换 一次
 */
public class BubbleSort {

    public static void main(String[] args) {

        int[] numArr = {36,66,16,6,8,9,99,56,68};

        int temp;
        for (int i = 0; i <numArr.length-1 ; i++) {
            for (int j = 0; j <numArr.length-1-i ; j++) {
                if(numArr[j]<numArr[j+1]){
                    temp = numArr[j];
                    numArr[j] = numArr[j+1];
                    numArr[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(numArr));
    }
}
