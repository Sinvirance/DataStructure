package com.queue;

import com.queue.arrayqueue.ArrayQueue;
import com.queue.loopqueue.LoopQueue;

import java.util.Random;

/**
 * @Author: Sinvirance
 * @Date: 2020/12/2 18:33
 * @Description: TODO
 */

public class Test {

    public static void main(String[] args) {
        int opCount = 10000;
        System.out.println("1111111111");
        Queue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue, time" + time2);

        Queue<Integer> arrayQueue = new ArrayQueue<>();
        double time1  = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue, time" + time1);

    }


    /**
     * 计算运行时间
     * @param q 不同实现的队列
     * @param opCount 传进从队列数量
     * @return 时间
     */
    private static double testQueue(Queue<Integer> q, int opCount) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
            long endTime = System.nanoTime();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
}
