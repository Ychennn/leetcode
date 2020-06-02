package com.yc.dp;

public class Solution37 {//最长回文子序列⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public static int longestPalindromeSubseq(String s) {//动态规划
        int len = s.length();
        if (len < 2) return len;
        //初始化dp二维数组
        // dp[i][j]表示第i个字符到第j个字符之间最长的回文子序列长度
        int[][] dp = new int[len][len];

        //反着遍历保证正确的状态转移,因为dp[i][j] = dp[i + 1][j - 1] + 2;
        //dp[i][j]跟左下角的值有关,所以从二维数组的最右下角开始反序遍历
        for (int i = len - 2; i >= 0; i--) {//注意边界
            dp[i][i] = 1;//初始化dp[i][i]
            for (int j = i + 1; j < len; j++) {
                // 状态转移方程
                if (s.charAt(i) == s.charAt(j)) {
                    //该表达式同时考虑到了奇偶
                    //当序列为 b aa b 时 -->i = 0, j = 3，则 dp[0][3] = dp[1][2] + 2 = 4
                    //当序列为 b a b 时 -->i = 0, j = 2，则 dp[0][2] = dp[1][1] + 2 = 3
                    //当序列为 b b 时 -->i = 0, j = 1，则 dp[0][1] = dp[1][0] = 0 + 2 = 2 (dp[1][0] 默认值为 0)
                    dp[i][j] = dp[i + 1][j - 1] + 2;

                } else {
                    //当 s[i] != s[j] ，那么 dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1])
                    //假如序列为 dcbcc（index：0-4），s[0] != s[4] ，
                    // 则 dp[0][4] = Math.max(dp[0][3],dp[1,4]) = Math.max(2,3) = 3
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        // 整个 s 的最长回文子串长度
        return dp[0][len - 1];
    }

    public static void main(String[] args) {
        String str = "bbbab";
        int i = longestPalindromeSubseq(str);
        System.out.println(i);
    }
}