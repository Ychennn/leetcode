package com.yc.bit;

import java.util.HashSet;

public class Solution24 {//只出现一次的数字2⭐⭐⭐⭐⭐⭐

    public int singleNumber(int[] nums) {
        //核心思想为统计所有数,对应二进制位1的个数
        //之后再通过sum%3,即获取到target在该位的二进制
        int res = 0;
        int sum;//临时保存所有数对应二进制位,1的个数之和
        for (int i = 0; i < 32; i++) {
            sum = 0;
            for (int num : nums) {
                sum += (num >> i) & 1;
            }
            //还原target
            res |= (sum % 3) << i;
        }
        return res;
    }

    public int singleNumber2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        long sumArray = 0;
        for (int num : nums) {
            sumArray += num;
            set.add(num);
        }

        //核心推理公式：
        //3×(a+b+c)−(a+a+a+b+b+b+c)=2c
        long sumSet = 0;
        for (int s : set) {
            sumSet += s;
        }
        //注意后面必须用括号全部包住
        return (int) ((sumSet * 3 - sumArray) / 2);
    }

    public static void main(String[] args) {
        Solution24 solution24 = new Solution24();
        int i = solution24.singleNumber(new int[]{2, 2, 3, 2});
        System.out.println(i);
    }
}
