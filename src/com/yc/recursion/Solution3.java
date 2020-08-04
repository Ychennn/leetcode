package com.yc.recursion;

public class Solution3 {//BiNode⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int rangeSumBST(TreeNode root, int L, int R) {//⭐⭐⭐⭐⭐
        if (root == null) return 0;

        //因为二叉搜索树,如果当前节点值比最小值小,只能从根节点都右子节点出发寻找
        if (root.val < L) return rangeSumBST(root.right, L, R);

        //同上
        if (root.val > R) return rangeSumBST(root.left, L, R);

        return root.val + rangeSumBST(root.right, L, R) + rangeSumBST(root.left, L, R);
    }
}
