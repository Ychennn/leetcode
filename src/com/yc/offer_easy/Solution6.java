package com.yc.offer_easy;

public class Solution6 {//二叉搜索树的第k大节点⭐⭐⭐⭐
    int res, n;

    public int kthLargest(TreeNode root, int k) {//中序遍历倒序+提前返回
        n = k;
        dfs(root);
        return res;
    }

    //中序顺序遍历,排序为从小到大,倒序则为从大到小
    //要求返回第k大的节点,配合提前返回提高效率
    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.right);//倒序⭐⭐
        if (--n == 0) {
            res = node.val;
            return;
        }
        dfs(node.left);//倒序⭐⭐
    }
}
