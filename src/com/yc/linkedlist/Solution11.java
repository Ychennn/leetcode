package com.yc.linkedlist;

public class Solution11 {//扁平化多级双向链表⭐⭐⭐⭐⭐⭐
    private Node prev = null;

    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    private void dfs(Node head) {//递归,难理解,还迭代效率衹
        if (head == null) return;

        //保存当前节点的下一个节点
        //在dfs(head.child)时,改变了head.next的指向,会造成栈溢出
        Node nextNode = head.next;

        if (prev != null) {
            prev.next = head;
            head.prev = prev;
        }
        prev = head;//画图
        dfs(head.child);//此时已经更改了指向

        head.child = null;//将child置空
        dfs(nextNode);
    }

    public Node flatten2(Node head) {//迭代
        Node tmp = head;
        while (tmp != null) {
            if (tmp.child != null) {
                Node nextNode = tmp.next;
                Node child = tmp.child;
                child.prev = tmp;
                tmp.next = child;//必须保证prev和next都正确,才是正确的双向链表
                tmp.child = null;

                while (child.next != null) {//找到child链表的最后一个节点
                    child = child.next;
                }
                //child指向nextNode
                child.next = nextNode;

                //如果下一个节点不为空,还需将下一个节点的prev指向child
                if (nextNode != null) nextNode.prev = child;
            }
            //画图
            tmp = tmp.next;
        }
        return head;
    }
}
