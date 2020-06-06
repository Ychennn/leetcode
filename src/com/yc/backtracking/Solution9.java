package com.yc.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution9 {
    List<List<Integer>> result = new ArrayList();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return result;
        }

        Arrays.sort(nums);//排序为了下面去重
        boolean[] used = new boolean[nums.length];
        ArrayList<Integer> list = new ArrayList();
        int depth = 0;
        dfs(nums, 0, used, list);
        return result;
    }

    private void dfs(int[] nums, int depth, boolean[] used, ArrayList<Integer> list) {//深度优先遍历+状态重置+剪枝
        if (depth == nums.length) {//当满足条件,加入到result中,并返回
            result.add(new ArrayList(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //i > 0 && nums[i] == nums[i - 1] 不能单独直接使用,因为
            //只单单满足了,如果以1为头元素,当遇到第二个以1为头元素的直接跳过
            //但如果没有!used[i - 1],如{1,1,2} -->1为头元素,此时只有两个选择1,2
            //但因为第二个1满足nums[i] == nums[i - 1],直接跳过跳过该元素,选择2时,剩下只能选剩余的1
            //但这个1同样满足nums[i] == nums[i - 1]也只能跳过,最终所有可能都会因为depth!=nums.length
            //不能输出,而加上了!used[i - 1]判断条件不仅满足如果以1为头元素,当遇到第二个以1为头元素的直接跳过
            //而且当以2为头元素时,只有选择1,1 当选择第一个1--> 可以正常输出[2,1,1],因为最后一个1不满足!used[i - 1],可以正常输出
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            //i > 0 && nums[i] == nums[i - 1] && used[i - 1] 也能获得正确答案
            // 区别仅在于保留的是相同元素的顺序索引，还是倒序索引

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
        List<List<Integer>> permute = solution9.permuteUnique(new int[]{1, 1, 2});
        System.out.println(permute);
    }
}
