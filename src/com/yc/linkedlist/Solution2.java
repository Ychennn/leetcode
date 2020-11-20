package com.yc.linkedlist;

import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {//回文链表⭐⭐⭐⭐⭐⭐

    public boolean isPalindrome(ListNode head) {//栈
        //也可以使用ArrayList保存head.val,再用左右索引get之后进行比较
        Deque<Integer> stack = new LinkedList<>();
        ListNode p = head;//指针
        while (head != null) {
            stack.push(head.val);
            head = head.next;

        }
        int len = stack.size() / 2;//减少比较次数,只比较一半的值
        while (len-- > 0) {
            if (p.val != stack.poll()) return false;
            p = p.next;
        }
        return true;
    }

    /*--------------------------------------------*/
    ListNode temp;

    public boolean isPalindrome2(ListNode head) {//递归⭐⭐⭐⭐⭐⭐画图理解
        temp = head;
        return check(head);
    }

    private boolean check(ListNode head) {
        if (head == null) return true;
        boolean res = check(head.next) && (temp.val == head.val);
        temp = temp.next;
        return res;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        boolean b = solution2.isPalindrome2(head);
        System.out.println(b);
    }
}
