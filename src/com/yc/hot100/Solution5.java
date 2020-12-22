package com.yc.hot100;

import java.util.Arrays;

public class Solution5 {//除自身以外数组的乘积⭐⭐⭐⭐⭐⭐

    //见offer_medium--Solution2
    public int[] productExceptSelf(int[] nums) {//画图
        if (nums.length == 0) return new int[0];
        //res[i]最终为a[0]*a[1]* ... *a[i-1]*a[i+1]* ... *a[a.length-1]
        int[] res = new int[nums.length];
        res[0] = 1;

        //第一轮循环后res[i] = a[0] * a[1]* ... * a[i-1]
        //第一轮结束后res[a.length-1]已是最终结果
        //所以第二轮循环从i=res.length-2开始
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int tmp = 1;
        //思路和第一轮循环一致,res[i]再乘除a[i+1]*a[i+2]*...*a[a.length-1]
        for (int i = res.length - 2; i >= 0; i--) {
            tmp *= nums[i + 1];
            res[i] *= tmp;
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
