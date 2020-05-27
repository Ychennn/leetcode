package com.yc.array;

import java.util.ArrayList;
import java.util.List;

public class Solution18 {//幂集

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        int count = (int) Math.pow(2, nums.length);//转换成对应的二进制，该位为1，加入集合
        // 从 nums.length 个 0 遍历到 nums.length 个 1
        for (int i = 0; i < count; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < nums.length; j++)
                // 将每一位右移最低位，检测其是否为1
                if ((i >>> j & 1) == 1) subset.add(nums[j]);
            subsets.add(subset);//>>>无符号右移
        }
        return subsets;
    }

    public static void main(String[] args) {
        List<List<Integer>> subsets = subsets(new int[]{1, 2, 3});
        System.out.println(subsets);
    }
}
