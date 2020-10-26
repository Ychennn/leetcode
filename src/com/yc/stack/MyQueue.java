package com.yc.stack;

import java.util.Deque;
import java.util.LinkedList;

public class MyQueue {//化栈为队⭐⭐⭐⭐⭐⭐
    private Deque<Integer> numStack;//该栈用来存放push的数
    private Deque<Integer> helpStack;//该栈用来模拟队列

    public MyQueue() {
        numStack = new LinkedList<>();
        helpStack = new LinkedList<>();
    }

    public void push(int x) {
        numStack.push(x);
    }

    public int pop() {
        peek();
        return helpStack.pop();
    }

    public int peek() {
        if (helpStack.isEmpty()) {//当helpStack为空时,才进行装填数据
            while (!numStack.isEmpty()) {
                helpStack.push(numStack.pop());
            }
        }
        return helpStack.peek();
    }

    public boolean empty() {
        return numStack.isEmpty() && helpStack.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        int peek = queue.peek();
        System.out.println(peek);
        queue.pop();
        int peek2 = queue.peek();
        System.out.println(peek2);
    }
}
