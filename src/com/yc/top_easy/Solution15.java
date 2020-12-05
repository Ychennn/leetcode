package com.yc.top_easy;

public class Solution15 {//Excel表列序号

    public int titleToNumber(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res * 26 + (s.charAt(i) - 'A' + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        String s = "ZY";
        int i = solution15.titleToNumber(s);
        System.out.println(i);
    }
}
