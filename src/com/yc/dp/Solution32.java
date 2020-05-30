package com.yc.dp;

public class Solution32 {//一次编辑

    public static boolean oneEditAway(String first, String second) {
        if (first == null || second == null) return false;
        if (first.equals(second)) return true;
        int len1 = first.length();
        int len2 = second.length();
        if (Math.abs(len1 - len2) > 1) return false;
        if (len1 > len2) {
            for (int i = 0; i < len2; i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    return first.substring(i + 1).equals(second.substring(i));
                }
            }
        } else if (len1 == len2) {
            for (int i = 0; i < len1; i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    return first.substring(i + 1).equals(second.substring(i + 1));
                }
            }
        } else {
            for (int i = 0; i < len1; i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    return first.substring(i).equals(second.substring(i + 1));
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean b = oneEditAway("b", "");
        System.out.println(b);
    }
}
