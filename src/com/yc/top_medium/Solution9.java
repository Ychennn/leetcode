package com.yc.top_medium;

public class Solution9 {//递增的三元子序列

    //时间复杂度->O(n),空间复杂度->O(1)
    public boolean increasingTriplet(int[] nums) {//双指针
        if (nums.length < 3) return false;

        int small = Integer.MAX_VALUE;//记录一个较小的数
        int mid = Integer.MAX_VALUE;//记录一个较小的数(mid>small)

        for (int num : nums) {//<=,'='防止如{1, 1, 1, 1}进入else return true;
            if (num <= small) {
                small = num;
            } else if (num <= mid) {
                mid = num;
            } else return true;//找到了一个数同时大于small和mid,返回true
        }
        return false;
    }

    //动态规划效率低:时间复杂度->O(n^2),空间复杂度->O(n)
    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
        int[] nums = {0, 0, 10, 0, 100};
        boolean b = solution9.increasingTriplet(nums);
        System.out.println(b);
    }
}
