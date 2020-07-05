package com.yc.greedy;

public class Solution11 {//摆动序列⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int wiggleMaxLength(int[] nums) {//动态规划
        if (nums.length < 2) return nums.length;

        //up[i]代表以nums[i]为最后一个元素的上升子序列
        int[] up = new int[nums.length];
        //down[i]代表以nums[i]为最后一个元素的下降子序列
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

        //加一是因为,数组未初始化为1,本身的值并未计算在内，所有加一
        return Math.max(up[nums.length - 1], down[nums.length - 1]) + 1;
    }


    public int wiggleMaxLength2(int[] nums) {//贪心算法
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
