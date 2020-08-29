package com.yc.dpointer;

public class Solution10 {//验证回文串⭐⭐⭐⭐⭐⭐⭐⭐

    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            //判断当前位是否为字符或数字
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            //判断当前位是否为字符或数字
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }

            if (l < r) {
                //都变为小写后再比较
                if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                    return false;
                }
                l++;
                r--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution10 solution10 = new Solution10();
        String s = "A man, a plan, a canal: Panama";
        boolean b = solution10.isPalindrome(s);
        System.out.println(b);
    }
}
