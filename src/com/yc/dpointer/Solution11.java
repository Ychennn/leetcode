package com.yc.dpointer;

import java.util.Arrays;

public class Solution11 {//合并两个有序数组⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;//指针1
        int p2 = n - 1;//指针2
        int index = m + n - 1;//nums1数组的使用下标
        while (p1 >= 0 && p2 >= 0) {
            //从后往前,可以不使用额外数组,防止元素被覆盖
            if (nums1[p1] > nums2[p2]) {
                nums1[index] = nums1[p1];
                p1--;
            } else {
                nums1[index] = nums2[p2];
                p2--;
            }
            index--;
        }

        //将nums2数组从下标0位置开始,拷贝到nums1数组中,从下标0位置开始，长度为p2+1
        //如果此时nums2数组使用完,因为p2的终止条件是 p2 >= 0,此时p2 = -1,下面的代码不执行
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }


    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        int m = 3;
        int n = 3;
        solution11.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
