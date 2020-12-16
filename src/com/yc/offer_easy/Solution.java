package com.yc.offer_easy;

public class Solution {//翻转单词顺序⭐⭐⭐

    public String reverseWords(String s) {//双指针
        //去除两边的空格,"  hello world!  "-->"hello world!"
        s = s.trim();

        int r = s.length() - 1, l = r;

        StringBuilder stb = new StringBuilder();

        while (l >= 0) {
            //从右到左找到第一个空格,此时截取字符串添加到stb,同时追加一个" "
            while (l >= 0 && s.charAt(l) != ' ') l--;
            stb.append(s.substring(l + 1, r + 1) + " ");

            //l从当前位置继续向左走,找到第一个最近一个字符,更新r指针
            while (l >= 0 && s.charAt(l) == ' ') l--;
            r = l;
        }

        //此时因为每次在截取字符串后追加一个空格,导致最终多了一个空格
        //该方法去除最后一个空格
        return stb.toString().trim();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "  hello world!  ";
        String reverse = solution.reverseWords(s);
        System.out.println(reverse);
    }
}