package com.yc.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution4 {//组合总和2
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target < 0) {
            return result;
        }
        Arrays.sort(candidates);
        ArrayList<Integer> list = new ArrayList();
        recursion(0, target, candidates, list);
        return result;
    }

    private void recursion(int start, int target, int[] candidates, ArrayList list) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList(list));
        } else {
            for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
                //去除重复,如{4,4,4}&&target=8 ---> 会出现{4,4},{4,4}
                //如果以当前结点为头结点的所有组合都找完了，那么下一个与他他相同的头结点就不用去找了
                //例如第一轮头元素是candidates[0] = 4
                //递归第二层candidates[1] = 4,满足条件加入result中,执行list.remove(list.size() - 1);
                //将list中的candidates[1]的4取出,i++此时i==2
                //当前以candidates[0]头节点的第二层递归进行到candidates[2] = 4,但此时start==1满足条件
                //continue;
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                list.add(candidates[i]);
                recursion(i + 1, target - candidates[i], candidates, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        //List<List<Integer>> lists = solution4.combinationSum2(new int[]{4, 4, 4}, 8);
        List<List<Integer>> lists = solution4.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        System.out.println(lists);
    }
}
