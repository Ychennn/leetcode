package com.yc.top_medium;

public class Solution3 {//摆动序列

    public int wiggleMaxLength2(int[] nums) {//动态规划
        if (nums.length < 2) return nums.length;

        int[] up = new int[nums.length];
        int[] down = new int[nums.length];

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    up[i] = Math.max(up[i], down[j] + 1);
                } else if (nums[i] < nums[j]) {
                    down[i] = Math.max(down[i], up[j] + 1);
                }
            }
        }
        return Math.max(up[nums.length - 1], down[nums.length - 1]) + 1;
    }

    public int wiggleMaxLength(int[] nums) {//动态规划优化
        if (nums == null || nums.length == 0) return 0;
        //up为最后两个数字递增的最长摆动序列长度
        //down最后两个数字递减的最长摆动序列长度
        int up = 1, down = 1;//初始为1
        for (int i = 1; i < nums.length; i++) {//从索引1开始
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int[] nums = {1, 7, 4, 9, 2, 5};
        int len = solution3.wiggleMaxLength2(nums);
        System.out.println(len);
    }
}
