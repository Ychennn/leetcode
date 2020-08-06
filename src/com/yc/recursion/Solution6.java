package com.yc.recursion;

import java.util.HashMap;

public class Solution6 {//重建二叉树⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐
    //因为需要反复遍历inorder数组,用map将值保存下来,便于查找
    HashMap<Integer, Integer> map = new HashMap<>();
    //便于buildTreeHelper使用preorder数组,且不需要在方法中传入
    int[] pre;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int pleft, int pright, int ileft, int iright) {
        if (pleft > pright || ileft > iright) {
            return null;
        }

        int rootval = pre[pleft];
        TreeNode root = new TreeNode(rootval);

        int rootindex = map.get(rootval);

        root.left = buildTreeHelper(pleft + 1,
                pleft + rootindex - ileft, ileft, rootindex - 1);

        root.right = buildTreeHelper(pleft + rootindex - ileft + 1,
                pright, rootindex + 1, iright);
        return root;
    }

    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] ineorder = {9, 3, 15, 20, 7};
        TreeNode root = solution6.buildTree(preorder, ineorder);
        System.out.println(root);
    }
}
