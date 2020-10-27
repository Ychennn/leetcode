package com.yc.stack;

import java.util.Deque;
import java.util.LinkedList;

public class Solution9 {//检查替换后的词是否有效⭐⭐⭐⭐⭐⭐

    public boolean isValid(String S) {//栈
        Deque<Character> stack = new LinkedList<>();
        for (char c : S.toCharArray()) {
            if (c == 'c') {//如果当前字符为c
                //从栈顶依次弹出2个元素并且顺序为"ba"
                if (stack.isEmpty() || stack.poll() != 'b')
                    return false;
                if (stack.isEmpty() || stack.poll() != 'a')
                    return false;
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid2(String S) {//"消消乐"
        while (S.contains("abc")) {
            S = S.replace("abc", "");
        }
        return S.equals("");
    }

    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
        String S = "ababcc";
        boolean b = solution9.isValid2(S);
        System.out.println(b);
    }
}
