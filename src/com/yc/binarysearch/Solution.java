package com.yc.binarysearch;

public class Solution {//x的平方根

    public static int mySqrt(int x) {//暴力法
        for (int i = 1; true; i++) {
            long tmp = (long) i * i;//不使用long的话，会出现问题
            if (tmp > x) return i - 1;
        }
    }

    public static int mySqrt2(int x) {//二分查找法
        int left = 0;
        int right = x;
        int mid;
        int result = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int i = mySqrt2(4);
        System.out.println(i);
    }
}
