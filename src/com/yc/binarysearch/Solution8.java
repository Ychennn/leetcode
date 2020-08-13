package com.yc.binarysearch;

public class Solution8 {//第一个错误的版本

    public boolean isBadVersion(int version) {//该方法leetcode提供
        return true;
    }

    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;//防止整数的溢出
            if (isBadVersion(mid)) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
}
