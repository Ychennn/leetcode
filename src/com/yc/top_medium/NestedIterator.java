package com.yc.top_medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {//扁平化嵌套列表迭代器
    List<Integer> res;//存放nestedList的integer
    Iterator<Integer> iterator;

    public NestedIterator(List<NestedInteger> nestedList) {
        res = new ArrayList<>();
        dfs(nestedList);
        iterator = res.iterator();
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    private void dfs(List<NestedInteger> nestedList) {//一次性处理,调用后,所有结果都在res中
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                res.add(nestedInteger.getInteger());
            } else {
                dfs(nestedInteger.getList());
            }
        }
    }
}