package com.yc.binarysearch;

public class Solution10 {//x的平方根⭐⭐⭐⭐⭐⭐⭐
    public int mySqrt(int x) {//二分法
        int left = 0;
        int right = x;
        int res = -1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;//防止溢出
            if ((long) mid * mid <= x) {//防止溢出
                res = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        return res;
    }


    public static void main(String[] args) {
        Solution10 solution10 = new Solution10();
        int i = solution10.mySqrt(8);
        System.out.println(i);
    }
}
