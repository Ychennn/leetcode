package com.yc.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution13 {//第k个排列⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐ 需二刷
    List<String> result = new ArrayList();

    public String getPermutation(int n, int k) {
        boolean[] isUsed = new boolean[n];
        StringBuilder stb = new StringBuilder();
        dfs(isUsed, n, k, stb);
        return result.get(k - 1);
    }

    /**
     * @param isUsed 标记对应元素是否使用过
     * @param n      对应getPermutation(..)的n
     * @param k      对应getPermutation(..)的n
     * @param stb    中间量临时保存元素
     */
    private void dfs(boolean[] isUsed, int n, int k, StringBuilder stb) {//效率极低
        if (result.size() == k) return;//剪枝

        if (stb.length() == n) {
            result.add(stb.toString());
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!isUsed[i - 1]) {
                stb.append(i);
                isUsed[i - 1] = true;

                dfs(isUsed, n, k, stb);

                isUsed[i - 1] = false;
                stb.deleteCharAt(stb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution13 solution13 = new Solution13();
        String permutation = solution13.getPermutation(9, 278621);
        System.out.println(permutation);
    }
}
