package com.yc.binarysearch;

public class Solution19 {//寻找重复数⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int findDuplicate(int[] nums) {//利用了抽屉原理
        int left = 1;//因为值只能为1~nums.length-1
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }

            //根据抽屉原理,小于等于4的个数如果严格大于4个
            //此时重复元素一定出现在 [1, 4] 区间里
            if (count > mid) {
                //重复元素位于区间 [left, mid]
                right = mid;
            } else {
                //if分析正确了以后,else搜索的区间就是if的反面
                //[mid + 1, right]
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution19 solution19 = new Solution19();
        int[] nums = new int[]{1, 2, 2, 4, 3};
        int i = solution19.findDuplicate(nums);
        System.out.println(i);
    }
}
