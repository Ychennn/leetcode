package com.yc.backtracking;

import java.util.ArrayList;
import java.util.List;

class Solution {//字母大小写全排列
    List<String> result = new ArrayList();

    public List<String> letterCasePermutation(String S) {
        recursion(S.toCharArray(), 0);
        return result;
    }

    //dfs递归,遍历每一个位置的字符
    //保持当前位置的字符不变,递归下一个位置
    //如果当前位置为字母,则再加一个大小写转换之后的递归分支
    private void recursion(char[] chars, int index) {
        if (index == chars.length) {
            result.add(new String(chars));
            return;
        }
        recursion(chars, index + 1);//递归
        if (chars[index] >= 'A') {//注意 >=
            chars[index] = chars[index] < 'a' ? (char) (chars[index] + 32) : (char) (chars[index] - 32);
            recursion(chars, index + 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> list = solution.letterCasePermutation("3Z4");
        System.out.println(list);
    }
}