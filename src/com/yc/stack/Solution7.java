package com.yc.stack;

import java.util.*;

public class Solution7 {//移除无效的括号⭐⭐⭐⭐⭐⭐⭐

    public String minRemoveToMakeValid(String s) {
        char[] sChars = s.toCharArray();
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < sChars.length; i++) {//栈相关操作
            if (sChars[i] == '(') {
                stack.push(i);
            } else if (sChars[i] == ')') {
                if (!stack.isEmpty() && sChars[stack.peek()] == '(') {
                    stack.poll();
                } else {
                    stack.push(i);
                }
            }
        }

        for (Integer idx : stack) {
            sChars[idx] = '#';//标志位,标志该位为非法括号
        }

        StringBuilder stb = new StringBuilder();
        for (char c : sChars) {
            if (c != '#') stb.append(c);
        }

        return stb.toString();
    }

    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        String s = "a)b";
        String str = solution7.minRemoveToMakeValid(s);
        System.out.println(str);
    }
}
