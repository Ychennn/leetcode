package com.yc.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution18 {
    List<String> result = new ArrayList();

    public String[] permutation(String S) {
        if (S == null || S.length() == 0) {
            return new String[0];
        }
        boolean[] isUsed = new boolean[S.length()];
        StringBuilder stb = new StringBuilder();
        dfs(S, isUsed, stb);
        return result.toArray(new String[result.size()]);
    }

    /**
     * @param S      被处理的字符串,即permutation(.)传入参数S
     * @param isUsed 该数组标记字符串S对应位是否被使用
     * @param stb    中间量,临时保存元素
     */
    private void dfs(String S, boolean[] isUsed, StringBuilder stb) {
        if (stb.length() == S.length()) {
            result.add(stb.toString());
            return;
        }

        for (int i = 0; i < S.length(); i++) {
            if (!isUsed[i]) {
                //使用当前元素
                stb.append(S.charAt(i));
                isUsed[i] = true;

                //递归调用
                dfs(S, isUsed, stb);

                //撤销当前操作
                stb.deleteCharAt(stb.length() - 1);
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution18 solution18 = new Solution18();
        String[] permutation = solution18.permutation("qwe");
        System.out.println(Arrays.toString(permutation));
    }
}
