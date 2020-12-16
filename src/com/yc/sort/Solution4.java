package com.yc.sort;

public class Solution4 {//归并排序

    public void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] tmpArr = new int[right - left + 1];//临时数组
        int l = left, r = mid + 1;
        int idx = 0;

        while (l <= mid && r <= right) {//合并两个有序的数组
            if (nums[l] < nums[r]) {
                tmpArr[idx++] = nums[l++];
            } else {
                tmpArr[idx++] = nums[r++];
            }
        }
        while (l <= mid) {//将左边剩余元素填充进temp中
            tmpArr[idx++] = nums[l++];
        }
        while (r <= right) {//将右序列剩余元素填充进temp中
            tmpArr[idx++] = nums[r++];
        }

        for (int i = 0; i < tmpArr.length; i++) {//将排好序的数,赋值回原数组
            nums[left + i] = tmpArr[i];
        }
    }
}
