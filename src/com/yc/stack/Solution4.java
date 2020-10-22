package com.yc.stack;

import java.util.Deque;
import java.util.LinkedList;

public class Solution4 {//整理字符串⭐⭐⭐⭐⭐⭐

    public String makeGood(String s) {
        Deque<Character> deque = new LinkedList<>();//双端队列
        for (char c : s.toCharArray()) {
            if (!deque.isEmpty()) {
                Character peek = deque.peek();
                if (peek == c - 32 || peek == c + 32) {
                    deque.poll();
                } else {
                    deque.push(c);
                }
            } else {
                deque.addFirst(c);
            }
        }
        StringBuilder stb = new StringBuilder();
        while (!deque.isEmpty()) {
            stb.append(deque.removeLast());
        }
        return stb.toString();
    }

    public String makeGood2(String s) {//双指针,效率高⭐⭐⭐⭐
        StringBuilder stb = new StringBuilder();
        int index = -1;
        for (char c : s.toCharArray()) {
            if (stb.length() > 0 && (stb.charAt(index) == c - 32 || stb.charAt(index) == c + 32)) {
                stb.deleteCharAt(index);
                index--;
            } else {
                stb.append(c);
                index++;
            }
        }
        return stb.toString();
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        String s = "leEeetcode";
        String str = solution4.makeGood2(s);
        System.out.println(str);
    }
}