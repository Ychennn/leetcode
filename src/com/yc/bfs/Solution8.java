package com.yc.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution8 {//特定深度节点链表⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode[] listOfDepth(TreeNode tree) {//bfs
        if (tree == null) return null;

        ArrayList<ListNode> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(tree);

        while (!queue.isEmpty()) {
            //记录下当前一轮队列的长度,因为后续的操作会改变长度,对fori循环造成影响
            int queueSize = queue.size();
            ListNode head = null;//头结点
            ListNode rear = null;//指针,指向最后一个结点

            for (int i = 0; i < queueSize; i++) {
                TreeNode poll = queue.poll();
                if (i == 0) {
                    head = new ListNode(poll.val);
                    rear = head;
                } else {
                    rear.next = new ListNode(poll.val);
                    rear = rear.next;
                }

                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
            result.add(head);
        }

        return result.toArray(new ListNode[result.size()]);
    }

    public static void main(String[] args) {
        Solution8 solution8 = new Solution8();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        ListNode[] listNodes = solution8.listOfDepth(root);
        System.out.println(listNodes);
    }
}
