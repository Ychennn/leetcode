package com.yc.dfs;

public class Solution {//将有序数组转换为二叉搜索树

    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int left, int right) {
        if (left > right) return null;

        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, left, mid - 1);
        root.right = dfs(nums , mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        TreeNode treeNode = solution.sortedArrayToBST(nums);
        System.out.println(treeNode);
    }
}