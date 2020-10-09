package com.yc.bit;

public class Solution5 {//插入⭐⭐⭐⭐⭐⭐⭐

    public int insertBits(int N, int M, int i, int j) {
        for (int k = i; k <= j; k++) {
            N &= ~(1 << k);//解决了溢出的问题

            //当k==31时会溢出
            /*if ((N & (1 << k)) == 1) {
                N -= (1 << k);
            }*/
        }
        return N + (M << i);
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        int i = solution5.insertBits(0, 31, 0, 4);
        System.out.println(i);
    }
}
