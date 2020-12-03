package com.yc.top_easy;

public class Solution7 {//3的幂

    public boolean isPowerOfThree(int n) {
        if (n < 1) return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        boolean b = solution7.isPowerOfThree(19);
        System.out.println(b);
    }
}
