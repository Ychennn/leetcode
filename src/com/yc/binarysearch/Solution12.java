package com.yc.binarysearch;

public class Solution12 {//山脉数组的峰顶索引

    public int peakIndexInMountainArray(int[] A) {
        int left = 0;
        int right = A.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (A[mid] > A[mid - 1] && A[mid] > A[mid] + 1) {
                return mid;
            } else if (A[mid] > A[mid - 1] && A[mid] < A[mid] + 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }

    public static void main(String[] args) {
        Solution12 solution12 = new Solution12();
        int[] A = new int[]{0, 1, 0};
        int i = solution12.peakIndexInMountainArray(A);
        System.out.println(i);
    }
}
