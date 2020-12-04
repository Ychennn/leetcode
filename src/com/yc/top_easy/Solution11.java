package com.yc.top_easy;

public class Solution11 {//罗马数字转整数⭐⭐⭐⭐⭐

    private int getValue(char c) {//罗马字母和十进制的映射
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public int romanToInt(String s) {
        int res = 0;
        int pre = getValue(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            int tmp = getValue(s.charAt(i));
            if (tmp > pre) {
                res -= pre;
            } else {
                res += pre;
            }
            pre = tmp;
        }
        res += pre;
        return res;
    }

    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        String s = "IX";
        int i = solution11.romanToInt(s);
        System.out.println(i);
    }
}
