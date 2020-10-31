package com.yc.stack;

import java.util.Deque;
import java.util.LinkedList;

public class Solution15 {//验证栈序列⭐⭐⭐⭐⭐⭐

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<>();
        int index = 0;

        //按照指定顺序入栈,如果为对应出栈的数,就把它从栈顶弹出
        for (int i : pushed) {
            stack.push(i);
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.poll();
                index++;
            }
        }
        //如果循环过后,栈为空即为合法的出栈序列
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        boolean b = solution15.validateStackSequences(pushed, popped);
        System.out.println(b);
    }
}
