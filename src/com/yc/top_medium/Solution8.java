package com.yc.top_medium;

import java.util.Deque;
import java.util.LinkedList;

public class Solution8 {//基本计数器2⭐⭐⭐⭐⭐⭐

    //相较于基本计数器,多了乘除法,但少了括号
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();

        char sign = '+';//标记正负
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {//防止空格干扰⭐⭐⭐⭐⭐

                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                num = 0;
                sign = c;
            }
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        Solution8 solution8 = new Solution8();
        String s = " 2* 2+4 ";
        int i = solution8.calculate(s);
        System.out.println(i);
    }
}
