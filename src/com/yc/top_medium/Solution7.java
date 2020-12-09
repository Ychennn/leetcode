package com.yc.top_medium;

import java.util.Deque;
import java.util.LinkedList;

public class Solution7 {//基本计算器⭐⭐⭐⭐⭐(同时完成了乘除法)

    private int i = 0;//公共索引控制循环

    //相较于基本计数器2,难度更大一些
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();

        char sign = '+';//标记正负
        int num = 0;
        for (; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {//处理左括号
                i++;
                num = calculate(s);
            }

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            //如果直接判断空格跳过该轮循环,如"2+3+ 4",会出现4没有如栈的情况,因为把" "当做sign判断
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
            if (c == ')') {//处理右括号
                break;
            }
        }

        //计算栈中的所有数之和
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        String s = "2+3+ 4";
        int i = solution7.calculate(s);
        System.out.println(i);
    }
}
