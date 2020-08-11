package com.yc.binarysearch;

import java.util.Arrays;

public class Solution7 {//两个数组的交集2

    //相较于两个数组的交集,该题少了去重的部分,也可以用hashmap求解
    public int[] intersect(int[] nums1, int[] nums2) {
        //先排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        //使用双指针求解
        int index1 = 0;
        int index2 = 0;

        //未使用arryList,直接使用数组,提升了效率
        int[] res = new int[Math.min(nums1.length, nums2.length)];
        int i = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] > nums2[index2]) {
                index2++;
            } else if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                res[i++] = nums1[index1];
                index1++;
                index2++;
            }
        }

        //克隆数组
        return Arrays.copyOfRange(res, 0, i);
    }

    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        int[] arr = solution7.intersect(nums1, nums2);
        System.out.println(Arrays.toString(arr));
    }
}
