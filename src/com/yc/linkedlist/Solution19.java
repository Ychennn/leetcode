package com.yc.linkedlist;

public class Solution19 {//两数相加⭐⭐⭐⭐⭐

    //两数相加2见Solution14⭐⭐⭐
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //哑节点
        ListNode res = new ListNode(0);
        ListNode tmp = res;
        int carry = 0;//进位
        while (l1 != null || l2 != null || carry != 0) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;

            int sum = a + b + carry;
            tmp.next = new ListNode(sum % 10);
            tmp = tmp.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

            carry = sum / 10;//进位更新
        }
        return res.next;
    }

    public static void main(String[] args) {
        Solution19 solution19 = new Solution19();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(9);
        ListNode l2 = new ListNode(9);
        ListNode sum = solution19.addTwoNumbers(l1, l2);
        System.out.println(sum);
    }
}
