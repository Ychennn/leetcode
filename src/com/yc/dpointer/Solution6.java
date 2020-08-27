package com.yc.dpointer;

public class Solution6 {//反转字符串中的元音字母

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        //左右指针
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            while (l < s.length() && !isVowel(chars[l])) l++;

            while (r >= 0 && !isVowel(chars[r])) r--;

            if (l < r) {
                char tmp = chars[r];
                chars[r--] = chars[l];
                chars[l++] = tmp;
            } else {
                //提前返回
                break;
            }
        }
        return new String(chars);
    }

    //判断是否为元音字母,包括大小写
    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }

    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        String s = "a.b,.";
        String reverseVowels = solution6.reverseVowels(s);
        System.out.println(reverseVowels);
    }
}
