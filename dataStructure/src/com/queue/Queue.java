package com.queue;

/**
 * @Author: Sinvirance
 * @Date: 2020/11/12 17:21
 * @Description: 队列接口
 */

public interface Queue<E> {
    boolean isEmpty();
    int getSize();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
