package com.yc.dp;

public class Solution20 {//回文子串
    public static int countSubstrings(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int count = 0;
        for (int i = 0; i < s.length() - 1; i++) {//i < s.length() - 1
            int oddCount = substring(s, i, i);
            int evenCount = substring(s, i, i + 1);
            count += oddCount + evenCount;
        }
        /*这一步是因为上面ii < s.length() - 1，省略了对最后一个odd奇数的判断，
        如abc，少判断了以c为中心的扩展的数量*/
        return count+1;
    }

    public static int substring(String s, int left, int right) {
        int len = s.length();
        int count = 0;
        while (left >= 0 && right < len) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int aa = countSubstrings("abc");
        System.out.println(aa);
    }
}
