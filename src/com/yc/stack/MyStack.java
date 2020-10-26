package com.yc.stack;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {//用队列实现栈⭐⭐⭐⭐⭐⭐⭐
    Queue<Integer> queue;//单队列实现

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {//具体,画图
        int n = queue.size();
        queue.add(x);
        for (int i = 0; i < n; i++) {
            queue.add(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.top());
        myStack.pop();
        System.out.println(myStack.top());
    }
}