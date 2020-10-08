package com.yc.bit;

public class Solution4 {//数组异或操作

    public int xorOperation(int n, int start) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            res ^= start + 2 * i;
        }
        //任何数和0做异或运算,结果仍为该数
        return res;
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int i = solution4.xorOperation(5, 0);
        System.out.println(i);
    }
}
