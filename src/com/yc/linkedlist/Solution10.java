package com.yc.linkedlist;

import java.util.Deque;
import java.util.LinkedList;

public class Solution10 {//从尾到头打印链表⭐⭐⭐⭐⭐⭐
    int index = 0;//数组的索引
    int len = 0;//用len来统计需要创建的数组的长度
    int[] res;

    public int[] reversePrint(ListNode head) {//递归
        dfs(head);
        return res;
    }

    private void dfs(ListNode node) {
        if (node == null) {
            res = new int[len];
            return;
        }
        len++;
        dfs(node.next);
        res[index++] = node.val;
    }

    public int[] reversePrint2(ListNode head) {//栈
        Deque<Integer> stack = new LinkedList<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        int[] res = new int[stack.size()];
        int index = stack.size() - 1;
        while (!stack.isEmpty()) {
            res[index--] = stack.pop();
        }
        return res;
    }
}
