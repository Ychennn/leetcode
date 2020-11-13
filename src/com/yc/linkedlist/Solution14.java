package com.yc.linkedlist;

import java.util.Deque;
import java.util.LinkedList;

public class Solution14 {//两数相加2⭐⭐⭐⭐⭐⭐

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode res = null;
        //只要栈不为空和进位不为0循环继续,如99 + 1,栈此时为空,但循环还要进行下去,正确结果为100
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = a + b + carry;//a和b和进位的和
            ListNode node = new ListNode(sum % 10);
            node.next = res;//画图⭐⭐⭐⭐⭐⭐
            res = node;
            carry = (sum) / 10;//进位
        }
        return res;
    }

    public static void main(String[] args) {
        Solution14 solution14 = new Solution14();
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        ListNode l2 = new ListNode(1);
        ListNode res = solution14.addTwoNumbers(l1, l2);
        System.out.println(res);
    }
}
