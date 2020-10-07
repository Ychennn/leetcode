package com.yc.bit;

class Solution {//缺失数字⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int missingNumber(int[] nums) {
        //初始值设为nums.length,因为数组的index不能取到nums.length
        //但数组的取值范围包括了nums.length
        int missNum = nums.length;
        for (int i = 0; i < nums.length; i++) {
            //missNum与index和nums[index]相异或
            missNum = i ^ nums[i];
        }
        return missNum;
    }
}