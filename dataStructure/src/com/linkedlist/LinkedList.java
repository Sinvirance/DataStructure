package com.linkedlist;

/**
 * @Author: Sinvirance
 * @Date: 2020/11/29 21:01
 * @Description: Linked List 的实现
 */

public class LinkedList<E> {

    // 私有的内部类，用户不需要知道链表的具体构成
    private class Node {
        public E e;
        // 对象的引用就相当于指针
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node (E e) {
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

    // 链表头指针
    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0 ;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * 在链表头添加新的元素 e
     * @param e 添加的元素 e
     */
    public void addFirst(E e) {
        //Node node = new Node(e);
        //node.next = head;
        //head = node;
        head = new Node(e, head);
        size ++;
    }


    /**
     * 在指定 index 插入元素节点 e
     * @param index 节点插入的位置
     * @param e LinkedList 节点的元素存储的数据
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, Illegal index");
        }
        if (index == 0) {
            addFirst(e);
        } else {
            Node prev = head;
            // 找到待插入索引 index位置 的前一个节点的指针
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }

            // Node node = new Node(e);
            // 两行代码不能交换，交换就变成 node.next = node, 指向 node 自己
            // node.next = prev.next;
            // prev.next = node;
            prev.next = new Node(e, prev.next);
            size ++;
        }
    }

    /**
     * 在链表末尾添加新的元素
     * @param e 添加的元素 e
     */
    public void addLast(E e) {
        add(size, e);
    }
}
