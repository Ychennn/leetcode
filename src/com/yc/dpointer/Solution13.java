package com.yc.dpointer;

public class Solution13 {//比较含退格的字符串⭐⭐⭐⭐⭐⭐⭐

    public boolean backspaceCompare(String S, String T) {
        return getStr(S).equals(getStr(T));
    }

    private String getStr(String s) {//双指针,未使用栈
        char[] chars = s.toCharArray();
        int index = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '#') {
                index--;
            } else {
                if (index < 0) {
                    index = 0;
                }
                chars[index++] = chars[i];
            }
        }
        //防止"###"
        if (index < 0) index = 0;
        return String.valueOf(chars, 0, index);
    }

    public static void main(String[] args) {
        Solution13 solution13 = new Solution13();
        String S = "ab#c";
        String T = "ad#c";
        boolean b = solution13.backspaceCompare(S, T);
        System.out.println(b);
    }
}
