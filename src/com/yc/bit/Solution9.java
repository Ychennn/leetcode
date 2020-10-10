package com.yc.bit;

public class Solution9 {//找不同⭐⭐⭐⭐⭐

    public char findTheDifference(String s, String t) {//精简版
        char res = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); i++) {
            res ^= s.charAt(i);
            res ^= t.charAt(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
        String s = "";
        String t = "y";
        char c = solution9.findTheDifference(s, t);
        System.out.println(c);
    }
}
