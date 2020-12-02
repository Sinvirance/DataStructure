package com.queue.linkedlistquene;

import com.queue.Queue;

/**
 * @Author: Sinvirance
 * @Date: 2020/12/2 13:07
 * @Description: 使用头尾指针链表实现队列
 */

public class LinkedListQueue<E> implements Queue<E> {
    public class  Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }
        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    /**
     * 链表尾巴 tail 添加元素，链表入队操作
     * @param e 插入队列的元素
     */
    @Override
    public void enqueue(E e) {
        // 边界操作: 当队列无元素时
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size ++;
    }

    /**
     * 从链表头 head 删除元素， 链表出队操作
     * @return retNode.e 将删除的返回
     */
    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from empty queue");

        Node retNode = head;
        head = head.next;
        // 将retNode 也就是删除之前的head 节点从我们的linked list 中断开
        retNode.next = null;

        // 边界处理，当删除元素后队列为空
        if (head == null)
            tail = null;

        size --;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from empty queue");

        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue front");

        Node cur = head;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }

}
