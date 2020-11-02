package com.yc.stack;

import java.util.Deque;
import java.util.LinkedList;

class MaxQueue {
    private Deque<Integer> numQueue;
    private Deque<Integer> maxQueue;

    public MaxQueue() {
        numQueue = new LinkedList<>();
        maxQueue = new LinkedList<>();
    }

    public int max_value() {
        return maxQueue.isEmpty() ? -1 : maxQueue.getFirst();
    }

    public void push_back(int value) {
        numQueue.addLast(value);
        while (!maxQueue.isEmpty() && value > maxQueue.getLast()) {
            maxQueue.removeLast();
        }
        maxQueue.addLast(value);
    }

    public int pop_front() {
        if (numQueue.isEmpty()) return -1;
        Integer num = numQueue.removeFirst();//减少了拆箱的操作,Integer类型之间的比较用equals
        if (num.equals(maxQueue.getFirst())) maxQueue.removeFirst();
        return num;
    }
}