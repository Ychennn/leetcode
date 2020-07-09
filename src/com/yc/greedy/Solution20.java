package com.yc.greedy;

public class Solution20 {//跳跃游戏⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public boolean canJump(int[] nums) {
        int rightmost = 0;//最远可以到达的位置
        for (int i = 0; i < nums.length; i++) {
            //只能从可达的地区进行跳跃,没有这个判断如{3, 2, 1, 0, 4}就会出现错误的解
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= nums.length - 1) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        int[] nums = new int[]{2, 3, 1, 1, 4};
//        int[] nums = new int[]{3, 2, 1, 0, 4};
//        int[] nums = new int[]{0};
        boolean b = solution20.canJump(nums);
        System.out.println(b);
    }
}
