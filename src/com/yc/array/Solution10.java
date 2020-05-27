package com.yc.array;

public class Solution10 {//移除元素

    public static int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 1, 4};
        int i = removeElement(ints, 1);
        for (int j = 0; j < i; j++) {
            System.out.print(ints[j] + " ");
        }
    }
}
