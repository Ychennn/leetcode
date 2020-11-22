package com.yc.hot100;

public class Solution2 {//反转二叉树⭐⭐⭐⭐⭐⭐

    public TreeNode invertTree2(TreeNode root) { //直接在root上改动
        if (root == null) return root;
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;

        invertTree2(root.left);
        invertTree2(root.right);
        return root;
    }

    public TreeNode invertTree(TreeNode root) {//未改变原root
        if (root == null) return root;
        TreeNode res = new TreeNode(root.val);

        res.left = invertTree(root.right);
        res.right = invertTree(root.left);

        return res;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(root);
        TreeNode node = solution2.invertTree(root);
        System.out.println(node);
    }
}
