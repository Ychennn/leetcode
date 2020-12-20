package com.yc.offer_easy;

public class Solution14 {//第一个只出现一次的字符

    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) return ' ';
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)] == 1) return s.charAt(i);
        }
        return ' ';
    }
}
