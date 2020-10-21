package com.yc.stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class Solution {//有效的括号⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>() {{
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }};

        Deque<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {//如果为左括号,入栈
                queue.addFirst(c);
            } else {//此时为右括号
                if (!queue.isEmpty()) {
                    if (map.get(queue.poll()) != c) {
                        return false;//如果栈顶弹出的括号和此时的c不匹配直接返回false
                    }
                } else {//此时栈为空,但却来了个右括号,也直接返回false
                    return false;
                }
            }
        }
        //循环结束时,栈为空,就为有效括号
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "{[]}";
        boolean b = solution.isValid(s);
        System.out.println(b);
    }
}
