package com.stack;

/**
 * @Author: Sinvirance
 * @Date: 2020/11/11 15:55
 * @Description: Stack 抽象接口
 */

public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    void pop();
    E peek();
}
