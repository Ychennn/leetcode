package com.yc.dp;

public class Solution16 {//解码⭐⭐⭐⭐⭐

    //见offer_medium.Solution5
    public int numDecodings(String s) {
        if (s.length() == 0 || s == null || s.charAt(0) == '0')
            return 0;

        //用dp[i]来表示前i个数一共有多少种翻译方法
        int[] dp = new int[s.length() + 1];
        //dp[0]没有实际意义,只是为了完成动态转换方程
        //如num=12,dp[1]=1,前2个数翻译方式共3种{1,2,12}即dp[2]=dp[0]+dp[1]
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            if (s.charAt(i - 1) == '0') {
                //当前数是0,判断前面一个数是不是1或2,是的话只能捆绑在一起,dp[i]=dp[i-2]
                if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2') {
                    dp[i] = dp[i - 2];
                } else return 0;
            } else if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6') {
                //如果当前数和前一个数组合在11-26,即可以单独翻译又可以组合翻译
                //单独翻译共dp[i-1]种方法,组合翻译共dp[i-2]种,dp[i]=dp[i-1]+dp[i-2]
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                //当前数只能单独翻译
                dp[i] = dp[i - 1];
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Solution16 solution16 = new Solution16();
        int i = solution16.numDecodings("12025");
        System.out.println(i);
    }
}
