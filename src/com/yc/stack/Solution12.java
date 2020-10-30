package com.yc.stack;

import java.util.*;

public class Solution12 {//链表中的下一个更大节点⭐⭐⭐⭐

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] nextLargerNodes(ListNode head) {//和Solution5,6相似
        List<Integer> list = new ArrayList<>();

        while (head != null) {//用list保存head节点的所有值
            list.add(head.val);
            head = head.next;
        }

        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {//顺序遍历
            while (!stack.isEmpty() && list.get(stack.peek()) < list.get(i)) {
                res[stack.poll()] = list.get(i);
            }
            stack.push(i);
        }
        return res;
    }

    public int[] nextLargerNodes2(ListNode head) {
        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[list.size()];

        for (int i = list.size() - 1; i >= 0; i--) {//倒序遍历
            while (!stack.isEmpty() && list.get(stack.peek()) <= list.get(i)) {
                stack.poll();
            }
            res[i] = stack.isEmpty() ? 0 : list.get(stack.peek());
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution12 solution12 = new Solution12();
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(5);
        int[] nums = solution12.nextLargerNodes2(head);
        System.out.println(Arrays.toString(nums));
    }
}
