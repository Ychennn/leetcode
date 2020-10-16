package com.yc.bit;

public class Solution20 {//数字范围按位与⭐⭐⭐⭐⭐⭐⭐⭐

    public int rangeBitwiseAnd(int m, int n) {
        int zeroCount = 0;
        while (n > m) {
            n >>= 1;
            m >>= 1;
            zeroCount++;
        }
        //n为公共前缀,因为后面只要有0,1相与对应位肯定为0
        //再左移0的位数位即为解
        return n <<= zeroCount;
    }

    public int rangeBitwiseAnd2(int m, int n) {
        while (n > m) {
            n &= (n - 1);
        }
        //同为获取公共前缀
        return n;
    }

    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        int i = solution20.rangeBitwiseAnd(5, 7);
        System.out.println(i);
    }
}
