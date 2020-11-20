package com.yc.linkedlist;

public class Solution26 {//反转链表2⭐⭐⭐⭐⭐⭐

    public ListNode reverseBetween(ListNode head, int m, int n) {//递归版
        if (m == 1) {
            return reverse(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    public ListNode reverseBetween2(ListNode head, int m, int n) {//非递归版
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        int i = m;
        while (i-- > 1) {
            cur = cur.next;//cur为需要反转的前一个节点
        }
        //将后面反转
        cur.next = reverse(cur.next, n - m + 1);
        return dummy.next;
    }

    ListNode successor = null;//后继节点

    private ListNode reverse(ListNode head, int n) {//该方法用于反转一个链表的前n个元素⭐⭐⭐⭐⭐
        if (n == 1) {
            //给后继节点复制,如1->2->3->4,反转前三个元素
            //此时4不参与反转,需保存下来,待反转完毕后,再连接起来
            successor = head.next;
            return head;//整体和反转整个链表思想类似
        }
        ListNode last = reverse(head.next, n - 1);
        head.next.next = head;
        //让反转之后的head节点和后面的节点连起来
        head.next = successor;
        return last;
    }

    public static void main(String[] args) {
        Solution26 solution26 = new Solution26();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode reverse = solution26.reverseBetween(head, 2, 3);
        System.out.println(reverse);
    }
}
