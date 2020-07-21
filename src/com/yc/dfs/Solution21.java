package com.yc.dfs;

public class Solution21 {//合法二叉搜索树⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    //不能只判断层级关系,如根节点为5,左子节点为3,左子节点的右子节点为6,是不符合条件的
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        //找寻左子树中的最右(数值最大)子节点
        //maxLeft.right != null不能省略⭐⭐⭐,除了叶子节点必须找到最值
        TreeNode maxLeft = root.left;
        while (maxLeft != null && maxLeft.right != null) {
            maxLeft = maxLeft.right;
        }

        //找寻右子树中的最左(数值最小)子节点
        TreeNode minRight = root.right;
        while (minRight != null && minRight.left != null) {
            minRight = minRight.left;
        }

        //叶子节点-->maxLeft&&minRight==null
        //判断是否符合条件
        boolean flag = (maxLeft == null || maxLeft.val < root.val) && (minRight == null || root.val < minRight.val);

        //从根节点往下判断
        return flag && isValidBST(root.left) && isValidBST(root.right);
    }


    public static void main(String[] args) {
        Solution21 solution21 = new Solution21();
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        boolean isValidBST = solution21.isValidBST(root);
        System.out.println(isValidBST);
    }
}
