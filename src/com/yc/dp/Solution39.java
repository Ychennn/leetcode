package com.yc.dp;

public class Solution39 {//最长重复子数组⭐⭐⭐⭐⭐⭐⭐⭐

    //滑动窗口参照binarysearch-30
    public int findLength(int[] A, int[] B) {//dp
        int res = 0;
        //长度为B.length + 1的原因是dp[j] = dp[j - 1] + 1;
        //这里优化了空间
        int[] dp = new int[B.length + 1];
        for (int i = 1; i <= A.length; i++) {
            //倒叙的原因是因为dp[j] = dp[j - 1] + 1即用到了前一个数字
            //如果不这样,每次得到的结果都会覆盖掉原先的数组,而dp[i][j+1]本该用到dp[i-1][j]
            //但dp[j] = dp[j - 1] + 1;之后则使用的是dp[i][j],倒叙则不会参数该影响
            for (int j = B.length; j > 0; j--) {
                if (A[i - 1] == B[j - 1]) {
                    dp[j] = dp[j - 1] + 1;
                } else {
                    dp[j] = 0;
                }
                res = Math.max(res, dp[j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution39 solution39 = new Solution39();
        int[] A = new int[]{1, 2, 3, 2, 1};
        int[] B = {3, 2, 1, 4, 7};
        int length = solution39.findLength(A, B);
        System.out.println(length);
    }
}
