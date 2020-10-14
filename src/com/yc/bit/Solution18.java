package com.yc.bit;

public class Solution18 {//翻转数位⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int reverseBits(int num) {
        int pre = 0;//记录出现0前面1的个数
        int curr = 0;//记录出现0后面1的个数
        int res = 0;

        while (num != 0) {
            if ((num & 1) == 1) {
                curr++;
            } else {//当遇到0时,更新res和pre的值并重置curr
                res = Math.max(res, curr + pre + 1);
                pre = curr;
                curr = 0;
            }
            num >>>= 1;
        }
        //num为 -1时特殊处理,返回32
        //最后Math.max(res, curr + pre + 1);是为了防止全为1的情况
        //如7 -> 111,并未进入else更新res的缘故
        return curr == 32 ? curr : Math.max(res, curr + pre + 1);
    }

    public static void main(String[] args) {
        Solution18 solution18 = new Solution18();
        int i = solution18.reverseBits(7);
        System.out.println(i);
    }
}
