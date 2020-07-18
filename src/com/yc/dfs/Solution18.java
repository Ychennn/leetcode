package com.yc.dfs;

import java.util.HashMap;
import java.util.Map;

public class Solution18 {//路径总和3⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    //双重递归效率不高-->一个递归遍历节点,一个递归求从当前节点出发的sum值
    public int pathSum(TreeNode root, int sum) {//前缀和,效率高
        //key是前缀和, value是大小为key的前缀和出现的次数
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        //前缀和为0的一条路径-
        prefixSumCount.put(0, 1);
        //前缀和的递归回溯思路
        return recursionPathSum(root, prefixSumCount, sum, 0);
    }


    private int recursionPathSum(TreeNode node, Map<Integer, Integer>
            prefixSumCount, int targetSum, int currSum) {
        if (node == null) return 0;

        currSum += node.val;

        int result = 0;

        result += prefixSumCount.getOrDefault(currSum - targetSum, 0);

        //更新路径上当前节点前缀和的个数
        prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);

        //进入下一层
        result += recursionPathSum(node.left, prefixSumCount, targetSum, currSum);
        result += recursionPathSum(node.right, prefixSumCount, targetSum, currSum);

        //回溯到上一层,如main方法中的root,遍历根节点 map添加{1,1},遍历左子树添加{-1,1}
        //遍历右子树,未回溯时 1+-3 =-2,会使用到{-1,1}，最终结果为2,显然是错误的,因为只有1+-2=-1
        //1+-3 != -1,未回溯造成了错误的结果
        prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) - 1);

        return result;
    }

    public static void main(String[] args) {
        Solution18 solution18 = new Solution18();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(-2);
        TreeNode right = new TreeNode(-3);
        root.left = left;
        root.right = right;
        int i = solution18.pathSum(root, -1);
        System.out.println(i);
    }
}
