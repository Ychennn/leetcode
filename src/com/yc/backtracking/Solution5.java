package com.yc.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution5 {//组合总和3⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐
    List<List<Integer>> result = new ArrayList();

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> list = new ArrayList<>();
        recursion(1, k, n, list);//因为要求1-9,所以从1开始
        return result;
    }

    /**
     * @param index 循环从当前的index开始
     * @param k     方法传入参数
     * @param n     方法传入参数
     * @param list  中间量临时保存元素
     */
    public void recursion(int index, int k, int n, List<Integer> list) {
        if (k == 0) {
            if (n == 0) {
                result.add(new ArrayList<Integer>(list));
                return;
            } else {
                return;
            }
        }

        for (int i = index; i <= 9; i++) {
            n -= i;
            list.add(i);

            //注意index是i+1而不是index+1⭐⭐⭐⭐
            recursion(i + 1, k - 1, n, list);

            //撤销当前操作
            n += i;
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        List<List<Integer>> lists = solution5.combinationSum3(3, 7);
        System.out.println(lists);
    }
}
