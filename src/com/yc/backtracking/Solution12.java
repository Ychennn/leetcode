package com.yc.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution12 {//组合
    List<List<Integer>> result = new ArrayList();

    public List<List<Integer>> combine(int n, int k) {
        // 特判
        if (n <= 0 || k <= 0 || n < k) {
            return result;
        }

        ArrayList<Integer> list = new ArrayList<>();
        recursion(1, k, n, list);
        return result;
    }

    /**
     * @param start 记录起始位置,防止重复选,只能选该值即及以后
     * @param k     指定每个list的长度,由combine方法传入参数指定
     * @param n     即能选用的最大值
     * @param list  中间量,临时保存元素
     */
    private void recursion(int start, int k, int n, List<Integer> list) {//自己方法效率低
        if (list.size() == k) {
            result.add(new ArrayList(list));
            return;
        }


        //剪枝操作优化,可省略,在递归调用时,如n=4&k=3
        //此时第一位选择了3不满足直接return;
        if (n - start + 1 < k - list.size()) {
            return;
        }//

        for (int i = start; i <= n; i++) {
            list.add(i);
            recursion(i + 1, k, n, list);

            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution12 solution12 = new Solution12();
        List<List<Integer>> combine = solution12.combine(4, 2);
        System.out.println(combine);
    }
}
