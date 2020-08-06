package com.yc.recursion;

public class Solution5 {//二叉搜索树节点最小距离⭐⭐⭐⭐⭐
    //前驱节点
    TreeNode pre = null;
    int res = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return res;
    }

    //中序遍历时候的值由小到大排列(二叉搜索树),最小值在相邻节点中获取
    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);

        if (pre != null) {
            res = Math.min(res, node.val - pre.val);
        }
        pre = node;
        dfs(node.right);
    }
}
