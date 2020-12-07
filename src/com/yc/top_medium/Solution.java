package com.yc.top_medium;

public class Solution {//字符串转换整数(atoi)⭐⭐⭐⭐

    public int myAtoi(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        int idx = 0;
        //去掉前面的空格
        while (idx < len && chars[idx] == ' ') {
            idx++;
        }

        //全是空格,返回0
        if (idx == len) return 0;

        boolean flag = true;//标记是否为正数
        if (chars[idx] == '+') {//如果第一个非空字符为+,idx++
            idx++;
        } else if (chars[idx] == '-') {//如果第一个非空字符为-,flag置为false,idx++
            flag = false;
            idx++;
        } else if (!Character.isDigit(chars[idx]))//如果不是+/-,且不是数字,返回0
            return 0;//如果第一个就为数字,不做处理

        int res = 0;

        while (idx < len && Character.isDigit(chars[idx])) {
            int cur = chars[idx] - '0';

            //如果s=Integer.MAX_VALUE,因为cur=7(Integer.MAX_VALUE % 10),不会进入if里面,循环结束返回
            //如果s=Integer.MIN_VALUE,因为cur=8>7(InteInteger.MAX_VALUE % 10),进入循环返回Integer.MIN_VALUE
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && cur > Integer.MAX_VALUE % 10)) {
                return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            res = res * 10 + cur;
            idx++;
        }

        //根据flag返回正数或负数
        return flag ? res : -res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.myAtoi("42");
        System.out.println(i);
    }
}
