package com.yc.top_medium;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NestedIterator2 implements Iterator<Integer> {//扁平化嵌套列表迭代器
    Deque<NestedInteger> stack = new LinkedList<>();

    public NestedIterator2(List<NestedInteger> nestedList) {//栈
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {//类似于懒加载,用到哪,加载到哪
        if (stack.isEmpty()) {
            return false;
        } else {
            if (!stack.peek().isInteger()) {
                NestedInteger pop = stack.pop();
                List<NestedInteger> list = pop.getList();

                for (int i = list.size() - 1; i >= 0; i--) {
                    stack.push(list.get(i));
                }
                return hasNext();
            } else {
                return true;
            }
        }
    }
}