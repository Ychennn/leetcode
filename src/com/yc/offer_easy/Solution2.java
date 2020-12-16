package com.yc.offer_easy;

public class Solution2 {//左旋转字符串⭐⭐⭐⭐

    public String reverseLeftWords(String s, int n) {//切片,思路一样
        StringBuilder res = new StringBuilder();
        for (int i = n; i < n + s.length(); i++) {
            res.append(s.charAt(i % s.length()));
        }
        return res.toString();
    }

    public String reverseLeftWords2(String s, int n) {//库函数
        return s.substring(n, s.length()) + s.substring(0, n);
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        String s = "abcdefg";
        String str = solution2.reverseLeftWords(s, 2);
        System.out.println(str);
    }
}
