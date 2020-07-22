package com.yc.dfs;

import java.util.ArrayList;
import java.util.List;

public class Solution24 {//路径总和2
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return result;
        List<Integer> list = new ArrayList<>();
        dfs(root, 0, sum, list);
        return result;
    }

    private void dfs(TreeNode node, int currSum, int targetSum, List<Integer> list) {
        if (node.left == null && node.right == null) {
            if (targetSum - currSum == node.val) {
                list.add(node.val);
                result.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
            }
            return;
        }

        list.add(node.val);

        if (node.left != null) dfs(node.left, currSum + node.val, targetSum, list);
        if (node.right != null) dfs(node.right, currSum + node.val, targetSum, list);
        //回溯
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        Solution24 solution24 = new Solution24();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
        root.right = right;
        List<List<Integer>> lists = solution24.pathSum(root, 30);
        System.out.println(lists);
    }
}
