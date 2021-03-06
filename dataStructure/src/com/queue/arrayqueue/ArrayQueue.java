package com.queue.arrayqueue;


import com.queue.Queue;

/**
 * @Author: Sinvirance
 * @Date: 2020/11/12 17:23
 * @Description: 数组实现队列
 */

public class ArrayQueue<E> implements Queue<E> {
    private DynamicArray<E> array;

    public ArrayQueue(int Capacity) {
        array = new DynamicArray<>(Capacity);
    }

    public ArrayQueue() {
        array = new DynamicArray<>();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue");
        res.append("front[");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1)
                res.append(",");
        }
        res.append("]tail");
        return res.toString();
    }
}
