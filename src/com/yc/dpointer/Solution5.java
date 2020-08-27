package com.yc.dpointer;

public class Solution5 {//实现strStr() ⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    //未使用kmp算法,效率低
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0 || needle == null) return 0;

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int j = 0;
            for (; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }

            if (j == needle.length()) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        String haystack = "mi";
        String needle = "mi";
        int i = solution5.strStr(haystack, needle);
        System.out.println(i);
    }
}
