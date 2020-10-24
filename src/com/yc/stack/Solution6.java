package com.yc.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution6 {//下一个更大元素2 ⭐⭐⭐⭐⭐

    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        //存储的是索引index,栈中的索引对应nums值从栈顶到栈底是单调不降的
        Deque<Integer> stack = new LinkedList<>();

        for (int i = nums.length * 2 - 1; i >= 0; i--) {//倒序遍历,因为环形,i取nums.length * 2 - 1
            //注意 <= ⭐⭐⭐⭐⭐⭐
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i % nums.length]) {
                stack.poll();
            }

            res[i % nums.length] = stack.isEmpty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);
        }
        return res;
    }

    public int[] nextGreaterElements2(int[] nums) {
        int[] res = new int[nums.length];
        Deque<Integer> stack = new LinkedList<>();
        Arrays.fill(res, -1);//初始化默认值⭐⭐⭐⭐⭐⭐⭐

        for (int i = 0; i < nums.length * 2; i++) {//顺序遍历,注意 < ⭐⭐⭐⭐⭐⭐
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % nums.length]) {
                res[stack.poll()] = nums[i % nums.length];
            }
            stack.push(i % nums.length);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        int[] nums = {1, 2, 1};
        int[] res = solution6.nextGreaterElements(nums);
        System.out.println(Arrays.toString(res));
    }
}
