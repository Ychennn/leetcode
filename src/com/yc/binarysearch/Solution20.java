package com.yc.binarysearch;

public class Solution20 {//搜索旋转排序数组⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int search(int[] nums, int target) {
        if (nums.length == 0 || nums == null) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        //这里如果为 <，最后一步需加一步判断 if (nums[left] == target) return left;
        //因为未到达while循环内的 if(nums[mid] == target) return mid;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;

            //nums[left] <= nums[mid] 是为了防只剩下2个数情况如{2,1} target=1
            //但却不能的出正确结果的情况
            if (nums[left] <= nums[mid]) {//前半部分有序
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;//target在前半部分
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[right] >= target && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        int[] nums = new int[]{2, 1};
        int target = 1;
        int i = solution20.search(nums, target);
        System.out.println(i);
    }
}
