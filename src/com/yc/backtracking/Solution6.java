package com.yc.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution6 {//子集

    public List<List<Integer>> subsets(int[] nums) {//二进制求解,为采用递归
        List<List<Integer>> result = new ArrayList();
        int numLen = nums.length;
        int resultLen = (int) Math.pow(2, numLen);
        for (int i = 0; i < resultLen; i++) {
            ArrayList<Integer> list = new ArrayList();
            for (int j = 0; j < numLen; j++) {
                if (((i >> j) & 1) != 0) {
                    list.add(nums[j]);
                }
            }
            result.add(list);
        }
        return result;
    }


    List<List<Integer>> result2 = new ArrayList<>();

    public List<List<Integer>> subsets2(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        backtracks(nums, 0, list);
        return result2;
    }

    public void backtracks(int[] nums, int index, List<Integer> list) {
        if (index == nums.length) {
            //这一步为什么需new Arraylist(list)
            //因为直接加入list,实际上加入的地址
            //后面又对它修改list.remove(list.size() - 1);
            //会造成元素为空
            result2.add(new ArrayList(list));
            return;
        }

        //不选择当前元素,直接跳过,进行下一次递归
        backtracks(nums, index + 1, list);

        //选择当前元素,加入集合,进行下一次递归
        list.add(nums[index]);
        backtracks(nums, index + 1, list);

        //回退操作,移除list中的末尾元素
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        List<List<Integer>> subsets = solution6.subsets2(new int[]{1, 2, 3});
        System.out.println(subsets);
    }
}
