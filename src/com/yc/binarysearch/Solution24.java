package com.yc.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class Solution24 {//找到 K 个最接近的元素⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public List<Integer> findClosestElements(int[] arr, int k, int x) {//双指针
        int len = arr.length;
        int left = 0;
        int right = len - 1;

        int count = len - k;

        //题目规定全为正数所有if判断条件如下
        while (count > 0) {
            //<= 是因为题目规定如果有两个数与x的差值一样,优先选择数值较小的那个数
            //如果是 < 则会返回较大的数
            if (x - arr[left] <= arr[right] - x) {
                right--;
            } else {
                left++;
            }
            count--;
        }
        List<Integer> result = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution24 solution24 = new Solution24();
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int k = 4;
        int x = 3;
        List<Integer> list = solution24.findClosestElements(arr, k, x);
        System.out.println(list);
    }
}
