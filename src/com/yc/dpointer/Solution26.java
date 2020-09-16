package com.yc.dpointer;

public class Solution26 {//长度最小的子数组⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int minSubArrayLen(int s, int[] nums) {//双指针
        int len = nums.length;
        //前后指针
        int i = 0, j = 0;
        int sum = 0;//数据和
        int res = Integer.MAX_VALUE;

        for (; j < len; j++) {
            sum += nums[j];

            while (sum >= s) {//只要满足条件,把最左边的数组减去并更新res,循环至不满足条件
                res = Math.min(res, j - i + 1);
                sum -= nums[i++];
            }
        }
        //最终可能没有符合条件的解则返回0
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        Solution26 solution26 = new Solution26();
        int s = 7;
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        int len = solution26.minSubArrayLen(s, nums);
        System.out.println(len);
    }
}
