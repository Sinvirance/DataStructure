package com.array.packagArray;

/**
 * @Author: Sinvirance
 * @Date: 2020/11/10 1:18
 * @Description: GenericArray 测试类
 */

public class TestGenericArray {
    public static void main(String[] args) {
        GenericArrray<Integer> array = new GenericArrray<>(20);
        for (int i = 0; i < 10 ; i++) {
            array.addLast(i);
        }
        System.out.println(array);


        array.add(1, 100);
        System.out.println(array);

        array.addFirst(-1);
        System.out.println(array);

        array.remove(2);
        System.out.println(array);

        array.removeElement(4);
        System.out.println(array);
    }
}