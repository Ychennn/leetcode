package com.yc.binarysearch;

import java.util.*;

public class Solution6 {//两个数组的交集

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }

        //set集合用来存放nums1的元素(去重)
        HashSet<Integer> set = new HashSet<>();
        //tmp集合用来存放nums1和nums2共有的元素
        HashSet<Integer> tmp = new HashSet<>();

        for (int i : nums1) {
            set.add(i);
        }

        for (int i : nums2) {
            if (set.contains(i)) tmp.add(i);
        }
        int[] res = new int[tmp.size()];
        int index = 0;
        for (Integer integer : tmp) {
            res[index++] = integer;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        int[] nums1 = new int[]{4, 9, 5};
        int[] nums2 = new int[]{9, 4, 9, 8, 4};
        int[] intersection = solution6.intersection(nums1, nums2);
        System.out.println(Arrays.toString(intersection));
    }
}
