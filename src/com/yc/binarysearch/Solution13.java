package com.yc.binarysearch;

public class Solution13 {//有效的完全平方数⭐⭐⭐⭐⭐⭐⭐⭐⭐
    public boolean isPerfectSquare(int num) {
        int left = 0;
        int right = num;
        int mid;
        int res = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if ((long) mid * mid <= num) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return res * res == num;
    }

    public static void main(String[] args) {
        Solution13 solution13 = new Solution13();
        boolean b = solution13.isPerfectSquare(15);
        System.out.println(b);
    }
}
