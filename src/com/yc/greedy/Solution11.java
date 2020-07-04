package com.yc.greedy;

public class Solution11 {//摆动序列⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int wiggleMaxLength(int[] nums) {//贪心算法
        if (nums.length < 2) return nums.length;

        int up = 1;//记录以第一个数字上升子序列的长度
        int down = 1;//记录以第一个数字下降子序列的长度

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }

        return Math.max(up, down);
    }

    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        int[] nums = new int[]{1, 7, 4, 9, 2, 5};
        //int[] nums = new int[]{1,17,5,10,13,15,10,5,16,8};
        //int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        int i = solution11.wiggleMaxLength(nums);
        System.out.println(i);
    }
}
