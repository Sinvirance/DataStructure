package com.array.firstArray;

/**
 * @Author: Sinvirance
 * @Date: 2020/11/9 21:59
 * @Description: Java 数组的基本使用
 */

public class basicArray {

    public static void main(String[] args) {
        int[] arr = new int[3];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;;
            System.out.println(arr[i]);
        }

        int[] scores = new int[] {1, 2, 3};
        for (int score: scores) {
            System.out.println(score);
        }
    }
}
