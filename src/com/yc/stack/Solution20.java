package com.yc.stack;

import java.util.Deque;
import java.util.LinkedList;

public class Solution20 {//移掉K位数字⭐⭐⭐⭐⭐

    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new LinkedList<>();

        for (char c : num.toCharArray()) {//画图
            while (!stack.isEmpty() && k > 0 && c < stack.peekLast()) {
                stack.removeLast();
                k--;
            }
            //这里的栈使用的是addLast和removeLast,便于后面遍历取出
            stack.addLast(c);
        }

        //如果是递增的,直接在末尾移除对应的个数
        while (k-- > 0) {
            stack.removeLast();
        }

        StringBuilder stb = new StringBuilder();
        boolean flag = true;//标志是否为前导零
        for (Character c : stack) {
            if (flag && c == '0') continue;
            flag = false;
            stb.append(c);
        }
        return stb.length() == 0 ? "0" : stb.toString();
    }

    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        String num = "10200";
        int k = 1;
        String str = solution20.removeKdigits(num, k);
        System.out.println(str);
    }
}
