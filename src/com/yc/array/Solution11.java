package com.yc.array;

public class Solution11 {//非递减数列⭐⭐⭐⭐⭐⭐

    public static boolean checkPossibility(int[] nums) {//3,4,2,3
        if (nums.length < 3) {
            return true;
        }
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
                if (count > 1) {
                    break;
                }
                if (i> 0 && nums[i - 1] >nums[i + 1]) {
                    nums[i+1] = nums[i];
                }else {
                    nums[i] = nums[i+1];
                }
            }
        }
        return count <= 1;
    }

    public static void main(String[] args) {
        int[] ints = {4, 2, 3};
        boolean b = checkPossibility(ints);
        System.out.println(b);
    }
}
