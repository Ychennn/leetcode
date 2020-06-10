package com.yc.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution16 {//子集2⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐
    HashSet<List<Integer>> sets = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        //必须先排序,在dfs,最终用hashSet保证唯一性
        Arrays.sort(nums);
//        List<Integer> list = new ArrayList();
//        dfs(nums, 0, list);
//
//        return new ArrayList(sets);
        dfs2(nums, 0, new ArrayList());
        return result;
    }

    /**
     * @param nums  被传入的数组
     * @param index 当前数组的索引
     * @param list  中间量
     */
    private void dfs(int[] nums, int index, List<Integer> list) {
        if (index == nums.length) {
            sets.add(new ArrayList(list));
            return;
        }
        //跳过当前元素
        dfs(nums, index + 1, list);

        //不跳过当前元素,添加进list中
        list.add(nums[index]);
        dfs(nums, index + 1, list);

        //撤销添加操作
        list.remove(list.size() - 1);
    }

    //-----------------------------------------------------
    List<List<Integer>> result = new ArrayList();

    private void dfs2(int[] nums, int index, List<Integer> list) {//优化⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐
        result.add(new ArrayList<>(list));

        for (int i = index; i < nums.length; i++) {
            //和上个数字相等就跳过
            //如此时第一层为1,第二层为2,第三层此时也为2,不满足continue条件,入集合中
            //撤销操作回溯到第一层为1,第二层为第二个2,满足continue条件,跳过
            //因为result中已经有{1,2}了,因为在第一层为1,第二层为第一个2的时候已经加入了集合中
            //此时再添加{1,2},肯定是会重复的,所有跳过
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            dfs2(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution16 solution16 = new Solution16();
        List<List<Integer>> lists = solution16.subsetsWithDup(new int[]{1, 2, 2});
        //List<List<Integer>> lists = solution16.subsetsWithDup(new int[]{4, 4, 4, 1, 4});
        System.out.println(lists);
    }
}
