package com.yc.dfs;

public class Solution21 {//求根到叶子节点数字之和

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return dfs(root, 0);
    }

    //如果用stb += node.val 最终再求和效率很低
    private int dfs(TreeNode node, int i) {//效率高,但节点的val只能为1位,否则需要改代码
        if (node == null) return 0;
        int tmp = i * 10 + node.val;
        if (node.left == null && node.right == null) {
            return tmp;
        }

        return dfs(node.left, tmp) + dfs(node.right, tmp);
    }

    public static void main(String[] args) {
        Solution21 solution21 = new Solution21();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        int i = solution21.sumNumbers(root);
        System.out.println(i);
    }
}
