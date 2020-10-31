package com.yc.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution14 {//每日温度

    public int[] dailyTemperatures(int[] T) {
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[T.length];

        for (int i = T.length - 1; i >= 0; i--) {//倒序遍历
            while (!stack.isEmpty() && T[stack.peek()] <= T[i]) {
                stack.poll();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }

    public int[] dailyTemperatures2(int[] T) {//顺序遍历
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[T.length];

        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                res[stack.peek()] = i - stack.peek();
                stack.poll();
            }
            stack.push(i);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution14 solution14 = new Solution14();
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] nums = solution14.dailyTemperatures2(T);
        System.out.println(Arrays.toString(nums));
    }
}
