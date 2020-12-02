package com.queue;


import com.queue.linkedlistquene.LinkedListQueue;

/**
 * @Author: Sinvirance
 * @Date: 2020/11/11 16:30
 * @Description: Queue 测试类
 */

public class TestQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedListQueue<>();

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if ( i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
