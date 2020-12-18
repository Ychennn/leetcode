package com.yc.offer_easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution7 {//和为s的连续正数序列⭐⭐⭐⭐

    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        //从1开始,l为左边界,r为右边界,sum为滑动窗口内数之和
        int l = 1, r = 1, sum = 0;

        while (l <= target / 2) {
            if (sum < target) {//sum<target,右边界右移,增大sum
                sum += r++;
            } else if (sum > target) {//反之,左边界右移,减小sum
                sum -= l++;
            } else {//如果相等,l~(r-1)就为一个解,-1是因为每次r++
                int[] arr = new int[r - l];
                for (int i = l; i < r; i++) {
                    arr[i - l] = i;
                }
                res.add(arr);
                //左边界向右移
                sum -= l++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        int[][] nums = solution7.findContinuousSequence(9);
        for (int[] num : nums) {
            System.out.println(Arrays.toString(num));
        }
    }
}
