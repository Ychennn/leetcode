package com.yc.stack;

import java.util.Deque;
import java.util.LinkedList;

public class Solution17 {//字符串解码⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public String decodeString(String s) {
        //该栈用来存放括号[]前面的倍数,即括号里面内容重复的次数
        Deque<Integer> countStack = new LinkedList<>();
        //该栈用来存放临时字符串,即括号[]前不需要重复的字符串,如a3[c],前者存放3,后者存放"a"
        Deque<String> strStack = new LinkedList<>();
        int count = 0;
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {//具体画图
            if (c == '[') {
                countStack.push(count);
                strStack.push(res.toString());
                count = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int currCount = countStack.poll();
                for (int i = 0; i < currCount; i++) tmp.append(res);
                res = new StringBuilder(strStack.poll() + tmp);
            } else if (c >= '0' && c <= '9') count = count * 10 + Integer.parseInt(c + "");
            else res.append(c);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        String s = "3[a2[c]]";
        String str = solution17.decodeString(s);
        System.out.println(str);
    }
}
