package com.yc.binarysearch;

public class Solution29 {//最长重复子数组⭐⭐⭐⭐⭐

    //动态规划参照dp-39
    public int findLength(int[] A, int[] B) {//滑动窗口
        int m = A.length;
        int n = B.length;
        int res = 0;
        //B固定,A移动
        for (int i = 0; i < m; i++) {
            int len = Math.min(n, m - i);
            int maxlen = maxLength(A, i, B, 0, len);
            res = Math.max(res, maxlen);
        }
        //A固定,B移动
        for (int i = 0; i < n; i++) {
            int len = Math.min(m, n - i);
            int maxlen = maxLength(A, 0, B, i, len);
            res = Math.max(res, maxlen);
        }
        return res;
    }

    //统计给定的数组最长字串长度
    private int maxLength(int[] A, int aStart, int[] B, int bStart, int len) {
        int max = 0;
        int count = 0;

        for (int i = 0; i < len; i++) {
            if (A[aStart + i] == B[bStart + i]) {
                count++;
            } else {
                count = 0;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution29 solution29 = new Solution29();
        int[] A = new int[]{1, 2/*, 3, 2, 1*/};
        int[] B = new int[]{/*3, 2,*/ 1, 2/*, 4, 7*/};
        int i = solution29.findLength(A, B);
        System.out.println(i);
    }
}
