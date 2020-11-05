package com.yc.stack;

import java.util.Deque;
import java.util.LinkedList;

public class Solution22 {//使括号有效的最少添加

    public int minAddToMakeValid(String S) {//解题思路和Solution21一致
        Deque<Character> stack = new LinkedList<>();
        for (char c : S.toCharArray()) {
            if (!stack.isEmpty() && (c == ')' && stack.peek() == '(')) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.size();
    }

    public int minAddToMakeValid2(String S) {//⭐⭐⭐⭐⭐效率高
        int left = 0;//左括号数量
        int right = 0;//需要补齐的右括号数量
        for (int i = 0; i < S.length(); i++) {//画图
            if (S.charAt(i) == '(') {
                left++;
            } else {
                if (left > 0) left--;
                else right++;
            }
        }
        return left + right;
    }

    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        String S = "()()";
        int i = solution22.minAddToMakeValid(S);
        System.out.println(i);
    }
}