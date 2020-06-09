package com.yc.backtracking;

import java.util.Arrays;
import java.util.HashSet;

public class Solution14 {//字符串的排列
    HashSet<String> result = new HashSet();//使用HashSet来保证唯一性

    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        boolean[] isUsed = new boolean[chars.length];
        StringBuilder stb = new StringBuilder();
        dfs(chars, isUsed, stb);
        String[] strings = result.toArray(new String[result.size()]);
        return strings;
    }

    private void dfs(char[] chars, boolean[] isUsed, StringBuilder stb) {
        if (stb.length() == chars.length) {
            result.add(stb.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (!isUsed[i]) {
                stb.append(chars[i]);
                isUsed[i] = true;

                dfs(chars, isUsed, stb);

                //撤销当前操作
                stb.deleteCharAt(stb.length() - 1);
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        String str = "abbc";
        Solution14 solution14 = new Solution14();
        String[] permutation = solution14.permutation(str);
        System.out.println(Arrays.toString(permutation));
    }
}
