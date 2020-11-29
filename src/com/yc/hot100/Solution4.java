package com.yc.hot100;

import java.util.*;

public class Solution4 {//找到所有数组中消失的数字⭐⭐⭐⭐⭐⭐⭐

    //题目要求不使用额外空间
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //1 <= nus[i] <= nums.length
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;//⭐⭐⭐⭐⭐⭐
            if (nums[idx] > 0) nums[idx] *= -1;
        }

        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] > 0) res.add(i);
        }
        //核心思想为将nums[idx]变为负数,再遍历数组
        //此时为正的nums[i-1]即为未被idx处理过,即将对应的i加入res中
        return res;
    }
}
