package com.yc.hot100;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution7 {//最短无序连续子数组⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int findUnsortedSubarray3(int[] nums) {//暴力优化法
        //l代表最左边不正确的索引,r代表最右边不正确的索引
        int l = nums.length, r = 0;
        //以当前nums[i]为参照物,找和他逆序的值的索引
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    r = Math.max(r, j);
                    l = Math.min(l, i);
                }
            }
        }
        //nums可能为递增的,此时l=nums.length,r=0,需特殊处理
        return r - 1 < 0 ? 0 : r - l + 1;
    }

    public int findUnsortedSubarray2(int[] nums) {//排序法
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        //将原先的数组复制后排序,和原数组机行比较,找l和r
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length; i++) {
            if (copy[i] != nums[i]) {
                r = Math.max(r, i);
                l = Math.min(l, i);
            }
        }
        //同findUnsortedSubarray3()
        return r - 1 < 0 ? 0 : r - l + 1;
    }

    public int findUnsortedSubarray(int[] nums) {//栈
        Deque<Integer> stack = new LinkedList<>();
        int l = nums.length, r = 0;
        //第一轮,顺序压栈,如果有逆序,则弹出栈顶的值直至符合条件,并一直更新l
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                l = Math.min(l, stack.pop());
            }
            stack.push(i);
        }

        stack.clear();
        //第二轮,倒序遍历数组压栈,如果有逆序的弹出栈顶的值直至符合条件,并一直更新r
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                r = Math.max(r, stack.pop());
            }
            stack.push(i);
        }

        return r - 1 < 0 ? 0 : r - l + 1;
    }

    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        int len = solution7.findUnsortedSubarray(nums);
        System.out.println(len);
    }
}
