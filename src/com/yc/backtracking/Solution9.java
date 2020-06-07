package com.yc.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution9 {//全排列⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐
    List<List<Integer>> result = new ArrayList();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return result;
        }

        boolean[] used = new boolean[nums.length];
        ArrayList<Integer> list = new ArrayList();
        int depth = 0;
        dfs(nums, 0, used, list);
        return result;
    }

    /**
     * @param nums  操作的对应数组
     * @param depth list的长度
     * @param used  标记是否使用过对应的nums[i]元素
     * @param list  中间量临时保存加入的数据
     */
    private void dfs(int[] nums, int depth, boolean[] used, ArrayList<Integer> list) {//深度优先遍历+状态重置+剪枝
        if (depth == nums.length) {//当满足条件,加入到result中,并返回
            result.add(new ArrayList(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {//每一轮代表以nums[i]为头元素进行dfs
            if (!used[i]) {//当前元素未使用过

                list.add(nums[i]);//加入list中
                used[i] = true;//把对应的used的boolean数组为置为true

                dfs(nums, depth + 1, used, list);//递归调用

                used[i] = false;//撤销操作
                list.remove(list.size() - 1);//移除list末尾的元素,进行下一轮操作
            }
        }
    }

    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
        List<List<Integer>> permute = solution9.permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }
}
