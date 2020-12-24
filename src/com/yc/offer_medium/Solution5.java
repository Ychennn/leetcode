package com.yc.offer_medium;

public class Solution5 {//把数字翻译成字符串⭐⭐⭐⭐

    //见dp.Solution16
    public int translateNum(int num) {
        if (num < 10) return 1;
        String str = String.valueOf(num);

        //用dp[i]来表示前i个数一共有多少种翻译方法
        int[] dp = new int[str.length() + 1];
        //dp[0]没有实际意义,只是为了完成动态转换方程
        //如num=12,dp[1]=1,前2个数翻译方式共3种{1,2,12}即dp[2]=dp[0]+dp[1]
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < str.length() + 1; i++) {
            //如果当前数和前一个数组合在10-25,即可以单独翻译又可以组合翻译
            //单独翻译共dp[i-1]种方法,组合翻译共dp[i-2]种,dp[i]=dp[i-1]+dp[i-2]
            if (str.charAt(i - 2) == '1' || (str.charAt(i - 2) == '2' && str.charAt(i - 1) <= '5')) {
                dp[i] = dp[i - 2] + dp[i - 1];
            } else {//如--38--,只能单独翻译str[i]不能和前面的数组合,dp[i]=dp[i-1]
                dp[i] = dp[i - 1];
            }
        }

        return dp[str.length()];
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        int i = solution5.translateNum(12258);
        System.out.println(i);
    }
}
