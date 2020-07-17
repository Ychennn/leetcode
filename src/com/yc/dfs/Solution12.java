package com.yc.dfs;

import java.util.ArrayList;
import java.util.List;

public class Solution12 {//递增顺序查找树⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public TreeNode increasingBST(TreeNode root) {//中序遍历+构造新的树 --> 效率不高
        List<Integer> list = new ArrayList<>();
        TreeNode node = new TreeNode(0);//创建一个父节点
        TreeNode curr = node;
        dfs(root, list);
        for (Integer integer : list) {
            curr.right = new TreeNode(integer);
            curr = curr.right;
        }
        return node.right;
    }

    private void dfs(TreeNode node, List<Integer> list) {
        if (node == null) return;
        dfs(node.left, list);
        list.add(node.val);
        dfs(node.right, list);
    }

    TreeNode curr;//相当于指针

    public TreeNode increasingBST2(TreeNode root) {//中序遍历 +  更改树的连接方式⭐⭐⭐⭐⭐⭐⭐
        TreeNode node = new TreeNode(0);//创建一个父节点
        curr = node;
        dfs2(root);
        return node.right;
    }

    private void dfs2(TreeNode node) {
        if (node == null) return;
        dfs2(node.left);
        curr.left = null;
        curr.right = node;
        curr = node;
        dfs2(node.right);
    }

    public static void main(String[] args) {
        Solution12 solution12 = new Solution12();
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(2);
        left.left = new TreeNode(1);
        TreeNode right = new TreeNode(4);
        root.left = left;
        root.right = right;
        TreeNode treeNode = solution12.increasingBST(root);
        System.out.println(treeNode);
    }
}
