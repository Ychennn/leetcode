package com.yc.stack;

import java.util.*;

class Solution19 {//二叉树的中序遍历⭐⭐⭐⭐⭐⭐

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        //用栈模拟递归的过程,具体画图
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode pop = stack.pop();
                res.add(pop.val);
                root = pop.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution19 solution19 = new Solution19();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> list = solution19.inorderTraversal(root);
        System.out.println(list);
    }
}