package com.yc.hot100;

public class Solution3 {//二叉树的直径⭐⭐⭐⭐⭐⭐⭐⭐⭐
    private int max = 0;

    //根据题目要求,这条路径可能穿过也可能不穿过根结点
    //用全局变量来max存放每个根节点左右子树最大深度之和
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return max;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        max = Math.max(left + right, max);//更新max值
        return Math.max(left, right) + 1;//返回node的最大深度值
    }
}
