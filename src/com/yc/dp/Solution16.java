package com.yc.dp;

public class Solution16 {//解码⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public static int numDecodings(String s) {
        if (s.length() == 0 || s == null || s.charAt(0) == '0')
            return 0;
        int pre = 1, curr = 1;//dp[-1] = dp[0] = 1
        for (int i = 1; i < s.length(); i++) {//必须使用'*'比较,不然直接用*作比较答案会出错
            int tmp = curr;
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    curr = pre;
                } else return 0;//防止连续的两个0或60
            } else if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) >= '1' && s.charAt(i) <= '6') {
                curr = curr + pre;
            }
            pre = tmp;
        }
        return curr;
    }

    public static void main(String[] args) {
        int i = numDecodings("10");
        System.out.println(i);
    }
}
