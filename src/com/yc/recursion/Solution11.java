package com.yc.recursion;


public class Solution11 {

    private Node prev = null;

    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    private void dfs(Node head) {//递归
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

    private Node flatten2(Node head) {//迭代
        Node tmp = head;
        while (tmp != null) {
            if (tmp.child != null) {//一定要注意prev和next,否则为非法的双向链表
                Node nextNode = tmp.next;
                Node child = tmp.child;
                child.prev = tmp;
                tmp.next = child;
                tmp.child = null;//child置空

                while (child.next != null) {
                    child = child.next;
                }//找到child链表的最后一个节点
                child.next = nextNode;//将child指向nextNode

                //如果不是最后一个节点的话,还需将nextNode的prev指向child
                if (nextNode != null) nextNode.prev = child;
            }
            tmp = tmp.next;
            //因为tmp = tmp.next,所以不会忽略掉child的child,具体画图
        }
        return head;
    }
}
