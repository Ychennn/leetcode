package com.yc.greedy;

import java.util.LinkedList;

public class Solution19 {//移调k位数字⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public String removeKdigits(String num, int k) {
        LinkedList<Character> stack = new LinkedList<>();

        //从左开始,用当前位和前面位的值相比较,小于的话,移除掉前面的值
        for (char c : num.toCharArray()) {
            while (stack.size() > 0 && k > 0 && stack.getLast() > c) {
                stack.removeLast();
                k--;
            }
            stack.add(c);
        }

        //防止没有移除够k位或单调递增的情况如12345,直接从末尾移除k位
        for (int i = 0; i < k; i++) {
            stack.removeLast();
        }

        //去除如num = "10200"&&k = 1的时候前面的零
        StringBuilder stb = new StringBuilder();
        boolean flag = true;
        for (Character character : stack) {
            if (flag && character == '0') continue;
            flag = false;
            stb.append(character);
        }

        return stb.length() == 0 ? "0" : stb.toString();
    }

    public static void main(String[] args) {
        Solution19 solution19 = new Solution19();
//        String num = "1432219";
        String num = "10200";
        int k = 3;
        String s = solution19.removeKdigits(num, k);
        System.out.println(s);
    }
}