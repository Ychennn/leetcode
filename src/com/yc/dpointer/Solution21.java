package com.yc.dpointer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution21 {//无重复字符的最长子串⭐⭐⭐⭐⭐

    public int lengthOfLongestSubstring(String s) {//滑动窗口
        int len = s.length();
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int end = 0, start = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }
            map.put(c, end);
            res = Math.max(res, end - start + 1);
        }
        return res;
    }

    public int lengthOfLongestSubstring2(String s) {//队列
        Queue<Character> queue = new LinkedList<>();
        char[] chars = s.toCharArray();
        int res = 0;
        for (char aChar : chars) {
            while (queue.contains(aChar)) {
                queue.poll();
            }

            queue.add(aChar);
            res = Math.max(res, queue.size());
        }
        return res;
    }

    public static void main(String[] args) {
        Solution21 solution21 = new Solution21();
        String s = "abcabcbb";
        int i = solution21.lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}