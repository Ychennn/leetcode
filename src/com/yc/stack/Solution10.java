package com.yc.stack;

import java.util.Deque;
import java.util.LinkedList;

public class Solution10 {//括号的分数⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int scoreOfParentheses(String S) {
        Deque<Integer> stack = new LinkedList<>();

        for (char c : S.toCharArray()) {//不选用Character栈是因为无法处理数和字符的转换
            if (c == '(') {//遇到左括号入栈,用0模拟
                stack.push(0);
            } else {
                //如果此时c==')'&&stack.peek() =='(',即出现"()",消灭该对括号,弹出左括号,并记录得分1
                if (stack.peek() == 0) {
                    stack.poll();
                    stack.push(1);
                } else {
                    int tmp = 0;
                    while (!stack.isEmpty() && stack.peek() != 0) {
                        tmp += stack.poll();
                    }
                    stack.poll();//同样弹出左括号,再入栈,否则会出错,具体画图
                    stack.push(tmp * 2);
                }
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {//此时栈内全为分数
            sum += stack.poll();
        }

        return sum;
    }


    public static void main(String[] args) {
        Solution10 solution10 = new Solution10();
        String S = "(()(()))";
        int i = solution10.scoreOfParentheses(S);
        System.out.println(i);
    }
}
