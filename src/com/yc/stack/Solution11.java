package com.yc.stack;

import java.util.*;

public class Solution11 {//反转每对括号间的子串⭐⭐⭐⭐⭐

    public String reverseParentheses(String s) {
        Deque<Integer> stack = new LinkedList<>();//该栈用来记录字符串s中左括号的索引
        char[] sChars = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {//反转的内容为(左括号+1 -> 右括号-1)
                reverse(sChars, stack.pop() + 1, i - 1);
            }
        }

        StringBuilder res = new StringBuilder();
        for (char c : sChars) {//去除括号
            if (c != '(' && c != ')') {
                res.append(c);
            }
        }
        return res.toString();
    }

    private void reverse(char[] sChars, int start, int end) {
        while (end > start) {//反转指定的字符
            char tmp = sChars[end];
            sChars[end] = sChars[start];
            sChars[start] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        String s = "(abcd)";
        String str = solution11.reverseParentheses(s);
        System.out.println(str);
    }
}
