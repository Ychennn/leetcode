package com.yc.dpointer;

public class Solution22 {//字符串的排列⭐⭐⭐⭐⭐⭐⭐

    public boolean checkInclusion(String s1, String s2) {//滑动窗口
        int len1 = s1.length();
        int len2 = s2.length();

        if (len1 > len2) return false;
        //用来统计对应区间内,各字符的个数
        int[] c1 = new int[26], c2 = new int[26];

        for (int i = 0; i < len1; i++) {
            c1[s1.charAt(i) - 'a']++;
            c2[s2.charAt(i) - 'a']++;
        }

        //这里不能更改为i <= len2,如果最后一个字母也不满足
        //s2.charAt(i)会发生越界异常
        for (int i = len1; i < len2; i++) {
            if (isEqual(c1, c2)) return true;

            c2[s2.charAt(i - len1) - 'a']--;
            c2[s2.charAt(i) - 'a']++;
        }

        //最后一步,是因为以s2最后一个字符为区间结束的字符没有判断到
        return isEqual(c1, c2);
    }

    //因为s1的字母的顺序不要求,所以判断s2是否有对应的子串
    //只需比较区间内的字母个数是否相同即可
    private boolean isEqual(int[] c1, int[] c2) {
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        String s1 = "ab";
        String s2 = "eidboaoo";
        boolean b = solution22.checkInclusion(s1, s2);
        System.out.println(b);
    }
}
