package com.queue.loopqueue;

import com.queue.Queue;
import com.queue.linkedlistquene.LinkedListQueue;

import javax.xml.stream.FactoryConfigurationError;
import java.awt.*;
import java.util.Dictionary;
import java.util.FormatFlagsConversionMismatchException;

/**
 * @Author: Sinvirance
 * @Date: 2020/12/2 17:43
 * @Description: 循环队列实现
 */

public class LoopQueue<E>  implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity) {
        // 比用户要求的空间多开辟一个，为了操作的方便
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public int getSize() {
        return size;
    }

    /**
     * 循坏队列入队操作
     * @param e 入队元素
     */
    @Override
    public void enqueue(E e) {
        // 当数组满扩容 * 2
        if ((tail + 1) % data.length == front)
            // 扩容
            resize(getCapacity() * 2);
        data[tail] = e;
        // %  data.lengt, 为了防止 tail 越界
        tail = (tail + 1) % data.length;
        size ++;
    }


    /**
     * 循坏队列出队操作
     * @return 出队元素
     */
    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue form empty queue");

        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;
        // 缩容
        if (size == getCapacity()/4 && getCapacity() /2 != 0)
            resize(getCapacity()/2);

        return ret;
    }

    /**
     * 循环队列扩容
     * @param newCapacity 扩容后的容量（-1）
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            // 由于出队操作将导致 front 在循环队列中的位置一直在移动
            // 在扩容时可以将元素位置重新安排
            // % data.length 是为了防止 i 越界
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }


    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue form empty queue");
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("LoopQueue: size=%d, capacity=%d\n", size, getCapacity()));
        res.append(String.format("LoopQueue front ["));

        for (int i = front; i != tail; i = (i + 1)% data.length){
            res.append(data[i]);
            if ((i + 1) % data.length != tail)
                res.append(",");
        }
        res.append("] tail");
        return res.toString();
    }
}
