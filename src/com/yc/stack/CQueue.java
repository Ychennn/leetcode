package com.yc.stack;

import java.util.Deque;
import java.util.LinkedList;

class CQueue {//用两个栈实现队列⭐⭐⭐⭐⭐⭐
    private Deque<Integer> numStack;
    private Deque<Integer> helpStack;


    public CQueue() {
        numStack = new LinkedList<>();
        helpStack = new LinkedList<>();
    }

    public void appendTail(int value) {
        numStack.push(value);
    }

    public int deleteHead() {
        if (helpStack.isEmpty()) {
            if (numStack.isEmpty()) {
                return -1;
            } else {
                while (!numStack.isEmpty()) {
                    helpStack.push(numStack.poll());
                }
            }
        }
        return helpStack.poll();
    }
}