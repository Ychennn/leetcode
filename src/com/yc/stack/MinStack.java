package com.yc.stack;

import java.util.Deque;
import java.util.LinkedList;

class MinStack {//栈的最小值⭐⭐⭐⭐⭐⭐⭐
    private Deque<Integer> numStack;
    private Deque<Integer> minStack;//辅助栈,由底至顶,递减存放数

    public MinStack() {
        numStack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int x) {
        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.push(x);
        }
        numStack.push(x);
    }

    public void pop() {
        //这里必须使用int而不能使用Integer
        //否则是对象进行比较,minStack不会弹出栈顶的数
        int poll = numStack.poll();
        if (poll == minStack.peek()) {
            minStack.poll();
        }
    }

    public int top() {
        return numStack.peek();
    }

    public int getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        return -1;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}