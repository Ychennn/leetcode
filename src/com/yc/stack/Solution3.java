package com.yc.stack;

import java.util.Deque;
import java.util.LinkedList;

public class Solution3 {//删除最外层的括号⭐⭐⭐⭐⭐⭐

    public String removeOuterParentheses(String S) {
        StringBuilder stb = new StringBuilder();
        int level = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') level++;
            //三个判断的顺序很重要,第一个和第三个可以交换
            //但level的判断应改为>0,具体分析画图
            if (level > 1) stb.append(c);
            if (c == ')') level--;
        }
        return stb.toString();
    }

    public String removeOuterParentheses2(String S) {//栈
        Deque<Character> stack = new LinkedList<>();
        StringBuilder stb = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (c == '(') {
                if (!stack.isEmpty()) stb.append(c);//利用栈非空来限制最外面的'('和')'
                stack.push(c);
            } else {
                stack.poll();
                if (!stack.isEmpty()) stb.append(c);
            }
        }
        return stb.toString();
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        String S = "(())";
        String str = solution3.removeOuterParentheses2(S);
        System.out.println(str);
    }
}
