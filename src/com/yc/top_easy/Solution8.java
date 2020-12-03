package com.yc.top_easy;

public class Solution8 {//字符串中的第一个唯一字符

    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;

        int[] map = new int[26];//用int[]替代map提高效率
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution8 solution8 = new Solution8();
        String s = "loveleetcode";
        int i = solution8.firstUniqChar(s);
        System.out.println(i);
    }
}
