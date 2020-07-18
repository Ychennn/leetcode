package com.yc.dfs;

import java.util.ArrayList;
import java.util.List;

public class Solution9 {//二叉树的而所有路径⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return new ArrayList<String>();
        ArrayList<String> list = new ArrayList<>();
//        dfs(root, list, "");
        dfs2(root, list, new StringBuilder());
        return list;
    }

    private void dfs(TreeNode root, ArrayList<String> list, String str) {//string效率低
        if (root.left == null && root.right == null) {
            str += root.val;
            list.add(str);
            return;
        }

        str += root.val + "->";
        if (root.left != null) dfs(root.left, list, str);
        if (root.right != null) dfs(root.right, list, str);
    }

    private void dfs2(TreeNode root, ArrayList<String> list, StringBuilder stb) {//stringBuilder
        if (root.left == null && root.right == null) {
            list.add(stb.toString() + root.val);
            return;
        }

        String tmp = root.val + "->";//记录当前添加的内容
        stb.append(tmp);
        if (root.left != null) dfs2(root.left, list, stb);
        if (root.right != null) dfs2(root.right, list, stb);
        //回溯
        stb.delete(stb.length() - tmp.length(), stb.length());
    }

    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        left.right = new TreeNode(5);
        root.left = left;
        root.right = new TreeNode(3);
        List<String> list = solution9.binaryTreePaths(root);
        System.out.println(list);
    }
}
