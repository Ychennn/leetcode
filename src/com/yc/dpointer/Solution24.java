package com.yc.dpointer;

import java.util.Arrays;

public class Solution24 {//颜色分类⭐⭐⭐⭐⭐⭐⭐

    public void sortColors(int[] nums) {
        int p1 = 0;//该指针左边全为0
        int p2 = nums.length - 1;//该指针右边全为2
        int curr = 0;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                swap(nums, p1, curr);
                p1++;
                curr++;
            } else if (nums[curr] == 1) {
                curr++;
            } else {//这一步没有i++的原因是交换过后的元素,在当前位并没有进行判断
                swap(nums, p2, curr);
                p2--;
            }
        }
    }

    private void swap(int[] nums, int idx1, int idx2) {//交换
        int tmp = nums[idx2];
        nums[idx2] = nums[idx1];
        nums[idx1] = tmp;
    }

    public static void main(String[] args) {
        Solution24 solution24 = new Solution24();
        int[] nums = new int[]{2,2};
        solution24.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
