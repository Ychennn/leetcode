package com.yc.hot100;

import java.util.Arrays;

public class Solution5 {//除自身以外数组的乘积⭐⭐⭐⭐⭐⭐

    public int[] productExceptSelf(int[] nums) {//画图
        int[] res = new int[nums.length];
        int left = 1, rigt = 1;

        for (int i = 0; i < nums.length; i++) {
            res[i] = left;
            left *= nums[i];
        }

        //如{1,2,3},第一轮循环res[3] = {1,1*1,1*1*2}
        //第二轮循环从数组最后一个值开始,res[3] = {{1}*3*2,{1*1}*3,2}
        for (int i = nums.length - 1; i > 0; i--) {
            rigt *= nums[i];
            res[i - 1] *= rigt;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        int[] nums = {1, 2, 3, 4};
        int[] arr = solution5.productExceptSelf(nums);
        System.out.println(Arrays.toString(arr));
    }
}
