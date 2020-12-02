package com.stack.linkedliststack;

import com.linkedlist.LinkedListDummyHead;
import com.stack.Stack;

/**
 * @Author: Sinvirance
 * @Date: 2020/11/30 3:56
 * @Description: 虚拟头节点LinkedList 实现栈 stack
 */

public class LinkedListStack<E> implements Stack<E> {
    private LinkedListDummyHead<E> linkedlist;

    public LinkedListStack() {
        linkedlist = new LinkedListDummyHead<>();
    }

    @Override
    public int getSize() {
        return linkedlist.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedlist.isEmpty();
    }

    @Override
    public void push(E e) {
        linkedlist.addFirst(e);
    }

    @Override
    public void pop() {
        linkedlist.removeFirst();
    }

    @Override
    public E peek() {
        return linkedlist.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Linkedlist Stack top:");
        res.append(linkedlist);
        return res.toString();
    }
}
