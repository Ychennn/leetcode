package com.yc.stack;

import java.util.*;

public class Solution18 {//去除重复字母⭐⭐⭐⭐⭐⭐⭐

    public String removeDuplicateLetters(String s) {
        int[] lastIdx = new int[26];//该数组用来记录所有字母最后出现的位置
        for (int i = 0; i < s.length(); i++) {
            lastIdx[s.charAt(i) - 'a'] = i;
        }

        boolean[] visited = new boolean[26];//该数组用来记录标记对应字符是否在栈中
        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);//如s=="acc",对于第二个c,此时已有一个c在栈中,直接跳过
            if (visited[c - 'a']) continue;

            //当栈不为空,且当前字符比栈顶的字符小且栈顶的字符不是最后一次出现,就将栈顶的字符弹出
            //因为后面还可以遇到,并且将该字符标记为不在栈中
            while (!stack.isEmpty() && c < stack.peek() && lastIdx[stack.peek() - 'a'] > i) {
                char pop = stack.pop();
                visited[pop - 'a'] = false;
            }

            //入栈
            stack.push(c);
            visited[c - 'a'] = true;
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, stack.poll());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution18 solution18 = new Solution18();
        String s = "cbacdcbc";
        String str = solution18.removeDuplicateLetters(s);
        System.out.println(str);
    }
}
