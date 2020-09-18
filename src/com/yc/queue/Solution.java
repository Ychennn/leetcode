package com.yc.queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {//滑动窗口的最大值⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[]{};
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < k; i++) { //未形成窗口
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();

        for (int i = k; i < nums.length; i++) { //形成窗口后
            //窗口向后滑动,如果双端队列的最大元素是nums[i-k]
            //直接移除,因为该区间并不包括该元素
            //如{1, 3, -1, -3, 5, 3, 6, 7} 区间 {3,-1,3}
            //下一个区间右移,此时不包含3,但此时的最大值为3,直接移除
            if (deque.peekFirst() == nums[i - k])
                deque.removeFirst();
            while (!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();

            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] window = solution.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(window));
    }
}
