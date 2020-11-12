package com.yc.linkedlist;

import java.util.HashMap;

public class Solution13 {//复杂链表的复制⭐⭐⭐⭐⭐⭐⭐

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {//哈希表⭐⭐⭐⭐
        Node curr = head;
        //key-->head的所有节点,val-->以curr.val的创建的节点
        HashMap<Node, Node> map = new HashMap<>();
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;//指针重新指向head
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }

        //画图
        return map.get(head);
    }

    public Node copyRandomList2(Node head) {//拼接+拆分
        if (head == null) return head;
        Node curr = head;
        while (curr != null) {
            //复制链表的各节点,并构建拼接链表 n --> n(clone) --> n1 --> ...
            //原先节点指向复制的节点,复制的节点则指向原先节点的next
            Node tmp = new Node(curr.val);
            tmp.next = curr.next;
            curr.next = tmp;
            curr = tmp.next;
        }

        curr = head;
        //此时已经复制完毕,while完成复制节点的random指向
        while (curr != null) {
            if (curr.random != null) {
                //这里是指向curr.random的复制节点,因为后面要拆分为2个链表
                //所以不能指向curr.random;
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        curr = head.next;
        //pre指针指向head,完成下面的拆分,保证head和原先的head一致
        Node pre = head, res = curr;
        //拆分,因为题目中规定head节点不能被改变,同时也将res分离出来⭐⭐⭐⭐⭐
        while (curr != null) {
            pre.next = pre.next.next;
            curr.next = curr.next.next;
            pre = pre.next;
            curr = curr.next;
        }
        pre.next = null;//此时pre指向的是pre的复制节点,置空
        return res;
    }
}
