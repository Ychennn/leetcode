package com.yc.stack;

import java.util.Deque;
import java.util.LinkedList;

public class Solution21 {//删除字符串中的所有相邻重复项2⭐⭐⭐⭐⭐⭐⭐⭐

    public String removeDuplicates(String s, int k) {//栈,该方法本质上和记忆计数法是一样的
        StringBuilder stb = new StringBuilder(s);
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < stb.length(); i++) {//这里不能使用s.length(),因为长度是在不断更新的
            if (i == 0 || stb.charAt(i) != stb.charAt(i - 1)) {
                stack.push(1);
            } else {
                stack.push(stack.pop() + 1);
                if (stack.peek() == k) {
                    stb.delete(i - k + 1, i + 1);
                    i = i - k;
                    stack.pop();
                }
            }
        }
        return stb.toString();
    }

    public String removeDuplicates2(String s, int k) {//记忆计数
        //相较于暴力法,省去了每次从零开始计数,直接将指针i移至上一个字母处
        StringBuilder stb = new StringBuilder(s);
        int[] counts = new int[stb.length()];
        for (int i = 0; i < stb.length(); i++) {
            if (i == 0 || stb.charAt(i) != stb.charAt(i - 1)) {
                counts[i] = 1;
            } else {
                counts[i] = counts[i - 1] + 1;
                if (counts[i] == k) stb.delete(i - k + 1, i + 1);
                i = i - k;
            }
        }
        return stb.toString();
    }

    public static void main(String[] args) {
        Solution21 solution21 = new Solution21();
        String s = "abbaa";
        int k = 2;
        String str = solution21.removeDuplicates(s, k);
        System.out.println(str);
    }
}
