package com.yc.dp;

public class Solution25 {//打家劫舍II ⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public static int rob(int[] nums) {
        /*因为首尾相连，因此可以把此环状排列房间问题约化为两个单排排列房间子问题：
        1-->在不偷窃第一个房子的情况下
        2-->在不偷窃最后一个房子的情况下
        综合偷窃最大金额:为以上两种情况的较大值，即 max(p1,p2)*/
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(robSolution(nums, 0, nums.length - 1),
                robSolution(nums, 1, nums.length));
    }

    private static int robSolution(int[] nums, int start, int end) {
        int pre = 0;
        int curr = 0;
        int tmp;
        for (int i = start; i < end; i++) {
            tmp = curr;
            curr = Math.max(pre + nums[i], curr);
            pre = tmp;
        }
        return curr;
    }

    public static void main(String[] args) {
        int rob = rob(new int[]{1, 1, 2, 1});
        System.out.println(rob);
    }
}
