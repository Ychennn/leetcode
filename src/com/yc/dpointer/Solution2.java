package com.yc.dpointer;

import java.util.Arrays;

public class Solution2 {//反转字符串

    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            swap(s, i++, j--);
        }
    }

    private void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        solution2.reverseString(s);
        System.out.println(Arrays.toString(s));
    }
}
