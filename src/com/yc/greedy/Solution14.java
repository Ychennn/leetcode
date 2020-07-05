package com.yc.greedy;

public class Solution14 {//使括号有效的最少添加⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int minAddToMakeValid(String S) {
        int result = 0;
        int left = 0;//左括号数

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                left++;
            } else if (S.charAt(i) == ')') {
                if (left > 0) {
                    left--;//消掉一个左括号
                } else {
                    result++;
                }
            }
        }
        //加上未消掉的左括号
        return result + left;
    }

    public static void main(String[] args) {
        Solution14 solution14 = new Solution14();
        String S = "()))((";
//        String S = ")))";
        int i = solution14.minAddToMakeValid(S);
        System.out.println(i);
    }
}
