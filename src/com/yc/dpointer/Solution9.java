package com.yc.dpointer;

public class Solution9 {
    public boolean isLongPressedName(String name, String typed) {
        int nlen = name.length();
        int tlen = typed.length();
        int i = 0, j = 0;

        //因为只能重复按,不能破坏顺序,如果第一个不相等,肯定是错误的
        if (name.charAt(0) != typed.charAt(0)) return false;

        while (i < nlen && j < tlen) {
            //如果相等,两个指针都向后移
            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (name.charAt(i - 1) != typed.charAt(j)) {//如果当前不等,且又不是重复前一个字符,肯定是错误的
                return false;
            } else {//当前不等,但是重复的上一个元素,
                j++;
            }
        }

        //如果type已经比对完,但name还有余,肯定是错误的
        if (i != nlen) return false;

        //这一步是为了便于比对type余下的字符,因为i此时指向name.length();
        i--;

        //如"alex","alex",并不会进入循环
        while (j < tlen) {
            if (name.charAt(i) != typed.charAt(j)) return false;
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
        String name = "alex";
        String typed = "alex";
        boolean b = solution9.isLongPressedName(name, typed);
        System.out.println(b);
    }
}
