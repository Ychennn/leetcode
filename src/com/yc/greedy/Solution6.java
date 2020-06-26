package com.yc.greedy;

public class Solution6 {//分割平衡字符串

    public int balancedStringSplit(String s) {//该题存在歧义,实际上须将全部元素使用掉
        int count = 0;
        int RCount = 0;
        int LCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                LCount++;
            } else {
                RCount++;
            }

            if (LCount > 0 && RCount > 0) {//只要能分割,立即分割
                count++;
                RCount = 0;
                LCount = 0;
            }
        }
        return count;
    }

    public int balancedStringSplit2(String s) {//该题实际的解法
        int count = 0;
        int RCount = 0;
        int LCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                LCount++;
            } else {
                RCount++;
            }

            if (RCount > 0 && LCount == RCount) {
                count++;
                RCount = 0;
                LCount = 0;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        //String s = "LLLLRRRR";
        String s = "RLRRRLLRLL";
        int i = solution6.balancedStringSplit2(s);
        System.out.println(i);
    }
}