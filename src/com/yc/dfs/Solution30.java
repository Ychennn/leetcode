package com.yc.dfs;

import java.util.ArrayList;
import java.util.List;

public class Solution30 {//特定深度节点链表⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode[] listOfDepth(TreeNode tree) {//dfs
        if (tree == null) return null;
        ArrayList<ListNode> result = new ArrayList<>();
        dfs(tree, result, 0);
        return result.toArray(new ListNode[result.size()]);
    }

    private void dfs(TreeNode node, List<ListNode> result, int depth) {
        if (node == null) return;
        depth += 1;

        if (depth - 1 == result.size()) {
            result.add(new ListNode(node.val));
        } else {
            ListNode listNode = result.get(depth - 1);
            ListNode tmp = listNode;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = new ListNode(node.val);
        }

        dfs(node.left, result, depth);
        dfs(node.right, result, depth);
    }
}
