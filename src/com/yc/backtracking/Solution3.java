package com.yc.backtracking;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3 {//组合总和⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐
    //因为每个元素可以重复使用,所以candidates未包含重复元素
    //不同于组合总和II即Solution4
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target < 0) {
            return result;
        }

        Arrays.sort(candidates);//优化⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐
        //整个递归都使用该list作为中间量
        ArrayList<Integer> list = new ArrayList();
        recursion(0, candidates, target, list);
        return result;
    }

    private void recursion(int start, int[] candidates, int target, List<Integer> list) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList(list));
        } else {
            //添加start的原因,是因为每次又重新开始从0遍历,对后续产生了干扰
            //如2 2 3 -- 2 3 2 重复,所以用start记录起始位置,即2 3 只能从3开始往后选
            //不能再选前面的2,防止了数据的重复
            //优化&& target >= candidates[i]⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐
            for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
                list.add(candidates[i]);
                //因为每个数字都可以使用无数次，所以递归还可以从当前元素开始
                recursion(i, candidates, target - candidates[i], list);
                //这一步防止重复添加 入 2 2 2 2 -> 此时不满足,但list中此时是 2 2 2 2
                //所有需要移除末尾的元素2,进行下一次递归2 2 2 3
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        List<List<Integer>> lists = solution3.combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(lists);
    }
}
