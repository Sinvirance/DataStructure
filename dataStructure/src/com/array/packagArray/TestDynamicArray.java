package com.array.packagArray;

/**
 * @Author: Sinvirance
 * @Date: 2020/11/10 1:18
 * @Description: DynamicArray 测试类
 */

public class TestDynamicArray {
    public static void main(String[] args) {
        DynamicArray<Integer> array = new DynamicArray<>(10);
        for (int i = 0; i < 10 ; i++) {
            array.addLast(i);
        }
        System.out.println(array);

        // 数组扩容
        array.add(1, 100);
        System.out.println(array);

        // 数组减容
        array.removeFirst();
        System.out.println(array);
        array.removeLast();
        System.out.println(array);

    }
}
