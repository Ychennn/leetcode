package com.yc.bit;

public class Solution12 {//将数字变成 0 的操作次数

    public int numberOfSteps(int num) {
        int res = 0;
        while (num != 0) {
            res++;
            if ((num & 1) == 1) num--;
            else num >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution12 solution12 = new Solution12();
        int i = solution12.numberOfSteps(14);
        System.out.println(i);
    }
}
