package com.yc.dp;

public class Solution10 {//最长回文子串,暴力法不能通过

    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;
        int maxLen = 1;//中心扩展法，需考虑两种情况如aba中间为奇数的回文子串和中间为偶数：abba的子串
        String result = s.substring(0, 1);
        // 中心位置枚举到 len - 2 即可
        for (int i = 0; i < len - 1; i++) {
            String oddStr = centerSpread(s, i, i);
            String evenStr = centerSpread(s, i, i + 1);
            String maxLenStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;
            if (maxLenStr.length() > maxLen) {
                maxLen = maxLenStr.length();
                result = maxLenStr;
            }
        }
        return result;
    }

    private static String centerSpread(String s, int left, int right) {
        // left = right 的时候，此时回文中心是一个字符，回文串的长度是奇数
        // right = left + 1 的时候，此时回文中心是一个空隙，回文串的长度是偶数
        int len = s.length();
        int i = left;
        int j = right;
        while (i >= 0 && j < len) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }
        // 这里要小心，跳出 while 循环时，恰好满足 s.charAt(i) != s.charAt(j)，因此不能取 i，不能取 j
        return s.substring(i + 1, j);
    }


    public static String longestPalindrome2(String s) {//动态规划法
        int len = s.length();
        if (len < 2) {
            return s;
        }
        boolean[][] dp = new boolean[len][len];
//        //初始化,可以省略因为没有使用
//        for (int i = 0; i < len; i++) {
//            dp[i][i] = true;
//        }
        int maxLen = 1;
        int start = 0;//i，j这样设置是为了防止如（1，4）这种但此时2，3还没有计算，没有体现出"无后效性"
        for (int j = 1; j < len; j++) {//i，j共有四种写法，都能满足无后效性
            for (int i = 0; i < j; i++) {
//                if (s.charAt(i) == s.charAt(j)) {
//                    if (j - i < 3) {
//                        dp[i][j] = true;
//                    } else {
//                        dp[i][j] = dp[i + 1][j - 1];
//                    }
//                } else {
//                    dp[i][j] = false;
//                }

                //以上的if else可以简写为
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                // 只要 dp[i][j] == true 成立，就表示子串 s[i, j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j]) {
                    int curLen = j - i + 1;
                    if (curLen > maxLen) {
                        maxLen = curLen;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        String babad = longestPalindrome2("baa");
        System.out.println(babad);

    }
}
