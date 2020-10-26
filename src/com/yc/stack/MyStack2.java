package com.yc.stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack2 {//用队列实现栈⭐⭐⭐⭐⭐⭐⭐
    Queue<Integer> numQueue;
    Queue<Integer> helpQueue;//辅助栈

    public MyStack2() {//双队列实现
        numQueue = new LinkedList<>();
        helpQueue = new LinkedList<>();
    }

    public void push(int x) {
        helpQueue.add(x);
        while (!numQueue.isEmpty()) {
            helpQueue.add(numQueue.poll());
        }

        Queue<Integer> tmp = numQueue;
        numQueue = helpQueue;
        helpQueue = tmp;
    }

    public int pop() {
        return numQueue.poll();
    }

    public int top() {
        return numQueue.peek();
    }

    public boolean empty() {
        return numQueue.isEmpty();
    }
}
