package com.yc.top_easy;

public class Solution12 {//有效的字母异位词⭐⭐⭐⭐⭐⭐

    public boolean isAnagram(String s, String t) {//用int[]替代map优化
        if (s.length() != t.length()) return false;
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;//用++,--操作,可以不用再开辟一个int[26]
            count[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution12 solution12 = new Solution12();
        String s = "anagram";
        String t = "nagaram";
        boolean b = solution12.isAnagram(s, t);
        System.out.println(b);
    }
}
