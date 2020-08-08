package com.yc.dac;


public class Solution {//多数元素⭐⭐⭐⭐⭐⭐⭐⭐

    //设置一个计数器votes,每遇到一个和当前的数字相同的数字,就让votes +1
    //遇到一个和当前数字不一样的数字,就让votes -1,当votes == 0时
    //就将res设置为当前遍历的数字,因为题目规定必定有一个数字出现次数超过数组长度的一半
    //所有最后得到的必然是正确答案
    public int majorityElement(int[] nums) {//摩尔投票法
        int votes = 0;//票数
        int res = 0;//最终结果

        for (int num : nums) {
            if (votes == 0) res = num;

            votes += res == num ? 1 : -1;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        int i = solution.majorityElement(nums);
        System.out.println(i);
    }
}