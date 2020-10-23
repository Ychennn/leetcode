package com.yc.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class Solution5 {//下一个更大元素1⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //维护一个单调栈,栈中的元素从栈顶到栈底是单调不降的
        Deque<Integer> stack = new LinkedList<>();

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {//画图
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }

        while (!stack.isEmpty()) {//剩余在栈中为后续没有比它大的数,按题目要求返回-1
            map.put(stack.pop(), -1);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] nums = solution5.nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(nums));
    }
}
