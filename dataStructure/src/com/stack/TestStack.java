package com.stack;

import com.stack.arraystack.ArrayStack;
import com.stack.linkedliststack.LinkedListStack;

/**
 * @Author: Sinvirance
 * @Date: 2020/11/11 16:30
 * @Description: ArrayStack 测试类
 */

public class TestStack {

    public static void main(String[] args) {
        new TestStack().testLinkedListStack();
    }

    public void testLinkedListStack() {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }

    public void testArrayStack() {
        ArrayStack<Integer> stack = new ArrayStack<>();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }

}
