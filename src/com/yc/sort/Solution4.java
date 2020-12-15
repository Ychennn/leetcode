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
        int i = left, j = mid + 1;
        int idx = 0;

        while (i <= mid && j <= right) {//合并两个有序的数组
            if (nums[i] < nums[j]) {
                tmpArr[idx++] = nums[i++];
            } else {
                tmpArr[idx++] = nums[j++];
            }
        }
        while (i <= mid) {//将左边剩余元素填充进temp中
            tmpArr[idx++] = nums[i++];
        }
        while (j <= right) {//将右序列剩余元素填充进temp中
            tmpArr[idx++] = nums[j++];
        }

        for (int k = 0; k < tmpArr.length; k++) {//将排好序的数,赋值回原数组
            nums[left + k] = tmpArr[k];
        }
    }
}
