package com.yc.dp;

public class Solution {//判断子序列
    public static boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int count = 0;
        int len = s.length();
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        for (int i = 0; i < t.length(); i++) {
            if (chars[count] == chart[i])
                count++;
            if (count == len) return true;
        }
        return false;
    }

    public static boolean isSubsequence2(String s, String t) {
        int index =-1;
        for (int i = 0; i < s.length(); i++) {
            index = t.indexOf(s.charAt(i),index+1);
            if(index ==-1) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean subsequence = isSubsequence2("abc", "addsbdsac");
        System.out.println(subsequence);
    }
}