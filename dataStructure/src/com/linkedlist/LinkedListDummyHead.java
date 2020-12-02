package com.linkedlist;

/**
 * @Author: Sinvirance
 * @Date: 2020/11/29 21:01
 * @Description: 引入了虚拟头节点 dummyHead
 */

public class LinkedListDummyHead<E> {

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

    // 虚拟头节点 不存储数据 只有对应的 next 指针指向第一个存储元素的节点
    private Node dummyHead;
    private int size;

    public LinkedListDummyHead() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
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

        Node prev = dummyHead;
        // 找到待插入索引 index位置 的前一个节点的指针
        // 虚拟头节点是个定义出来的概念，并不存储元素，只是永远占据第一个节点位置 ，所以便利次数为 index 次
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        // Node node = new Node(e);
        // 两行代码不能交换，交换就变成 node.next = node, 指向 node 自己
        // node.next = prev.next;
        // prev.next = node;
        prev.next = new Node(e, prev.next);
        size ++;
    }

    /**
     * 在链表头添加新的元素 e
     * @param e 添加的元素 e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在链表末尾添加新的元素
     * @param e 添加的元素 e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获得Linked List 第 index 为位置的节点值
     * @param index 节点的位置
     * @return Node.e 节点存储的值
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed, Illegal index");
        }

        Node current = dummyHead.next;
        for(int i = 0; i < index ; i++) {
            current = current.next;
        }
        return current.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }


    /**
     * 修改Linked List 第 index 为位置的节点值
     * @param index 节点的位置
     * @param e 节点修改后的值
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed, Illegal index");
        }

        Node current = dummyHead.next;
        for(int i = 0; i < index ; i++) {
            current = current.next;
        }
        current.e = e;
    }


    /**
     * 查找链表中是否存在元素 e
     * @param e 判断的值
     * @return 存在：true  否则：false
     */
    public boolean contains(E e) {
        Node current = dummyHead.next;
        while (current != null) {
            if (current.e.equals(e))
                return true;
            current = current.next;
        }
        return false;
    }


    /**
     * 删除 Linked List 第 index 为位置的节点值
     * @param index 节点的位置
     * @return Node.e 删除节点的元素值
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed, Illegal index");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size --;
        return retNode.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        //Node current = dummyHead.next;
        //while (current != null) {
        //    res.append(current.e + "->");
        //    current = current.next;
        //}

        for (Node current = dummyHead.next; current != null; current = current.next)
            res.append(current.e + "->");

        res.append("NULL");
        return res.toString();
    }
}
