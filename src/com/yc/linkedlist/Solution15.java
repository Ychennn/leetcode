package com.yc.linkedlist;

public class Solution15 {//两两交换链表中的节点⭐⭐⭐⭐⭐⭐

    public ListNode swapPairs2(ListNode head) {//迭代
        if (head == null || head.next == null) return head;
        //必须借助pre节点,如果原地交换会出错,如 1->2,head指向1
        //原地交换后 2->1,返回head结果为1->null
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode tmp = pre;//pre节点为待交换的2个节点的前一个节点,辅助交换
        while (tmp.next != null && tmp.next.next != null) {
            ListNode node1 = tmp.next;
            ListNode node2 = tmp.next.next;
            tmp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            tmp = node1;//画图⭐⭐⭐⭐⭐⭐⭐
        }
        return pre.next;
    }

    public ListNode swapPairs(ListNode head) {//递归,难理解⭐⭐⭐⭐⭐⭐⭐
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);//这一步和下一步不能交换顺序,否则会栈溢出 --
        next.next = head;//画图
        return next;
    }

    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode node = solution15.swapPairs(head);
        System.out.println(node);
    }
}
