package com.yc.hot100;

import java.util.ArrayList;
import java.util.List;

public class Solution10 {//找到字符串中所有字母异位词⭐⭐⭐⭐⭐

    public List<Integer> findAnagrams(String s, String p) {//滑动窗口
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) return res;

        int[] map = new int[26];//记录p所包含的所有字符
        for (char c : p.toCharArray()) map[c - 'a']++;

        int[] cur = new int[26];//记录当前窗口所包含的字母(预处理第一个窗口)
        for (int i = 0; i < p.length(); i++) {
            cur[s.charAt(i) - 'a']++;
        }
        //如果第一个窗口相同,将索引0加入集合
        if (isSame(map, cur)) res.add(0);

        int index = 0;
        //开始滑动,index指向上一个窗口的第一个字符
        for (int i = p.length(); i < s.length(); i++) {//画图
            cur[s.charAt(index++) - 'a']--;
            cur[s.charAt(i) - 'a']++;
            if (isSame(map, cur)) res.add(index);
        }
        return res;
    }

    private boolean isSame(int[] arr1, int[] arr2) {//判断窗口内容是否和p相等
        for (int i = 0; i < 26; i++)
            if (arr1[i] != arr2[i]) return false;
        return true;
    }

    public static void main(String[] args) {
        Solution10 solution10 = new Solution10();
        String s = "abab";
        String p = "ab";
        List<Integer> list = solution10.findAnagrams(s, p);
        System.out.println(list);
    }
}
