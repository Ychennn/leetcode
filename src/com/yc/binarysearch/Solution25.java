package com.yc.binarysearch;


public class Solution25 {//转变数组后最接近目标值的数组和⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int findBestValue(int[] arr, int target) {
        int left = 0;
        int right = 0;

        //左边从0开始的原因是因为最终结果可能不在数组的max和min范围中
        for (int i : arr) {
            right = Math.max(i, right);
        }

        int mid;
        //该二分查找,并非是查找原数组,所以不需要将原数组排序
        while (left < right) {
            mid = left + (right - left) / 2;

            //这里也可以改为 >target ,但需要更改while条件和right = mid -1;否则会出现死循环
            if (getSum(arr, mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int tmpSum1 = getSum(arr, left);
        int tmpSum2 = getSum(arr, left - 1);

        // >= 是因为同样的绝对值,选取较小的数
        if (Math.abs(target - tmpSum1) >= Math.abs(target - tmpSum2)) {
            return left - 1;
        } else return left;
    }

    public int getSum(int[] arr, int value) {
        int sum = 0;
        for (int i : arr) {
            sum += Math.min(i, value);
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution25 solution25 = new Solution25();
        int[] arr = new int[]{4, 9, 3};
        int target = 10;
        int i = solution25.findBestValue(arr, target);
        System.out.println(i);
    }
}
