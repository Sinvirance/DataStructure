package com.stack.arraystack;

import com.stack.Stack;

/**
 * @Author: Sinvirance
 * @Date: 2020/11/11 15:58
 * @Description: Stack 的第一种实现方式: ArrayStack
 */

public class ArrayStack<E> implements Stack<E> {
    DynamicArray<E> array;

    public ArrayStack(int Capacity) {
        array = new DynamicArray<>(Capacity);
    }

    public ArrayStack() {
        array = new DynamicArray<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public void pop() {
        array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack:");
        res.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1)
                res.append(",");
        }
        res.append("] Top");
        return res.toString();
    }
}
