package com.linkedlist;

/**
 * @Author: Sinvirance
 * @Date: 2020/11/30 2:51
 * @Description: 测试Linked List
 */

public class testLinkedList {
    public static void main(String[] args) {
        LinkedListDummyHead<Integer> linkedList = new LinkedListDummyHead<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2, 666);
        System.out.println(linkedList);
        linkedList.remove(2);
        System.out.println(linkedList);
        linkedList.removeFirst();
        System.out.println(linkedList);
        linkedList.removeLast();
        System.out.println(linkedList);
        linkedList.set(2, 666);
        System.out.println(linkedList);
        System.out.println(linkedList.contains(666));

    }
}
