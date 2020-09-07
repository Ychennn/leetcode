package com.yc.dpointer;

import java.util.Arrays;

public class Solution16 {//删除排序数组中的重复项 2 ⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    //对照solution删除排序数组中的重复项
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int i = 0;
        int j = 1;

        //计数器,因为重复的数最多只能有2个
        int count = 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                count++;
                if (count <= 2) {
                    nums[++i] = nums[j];
                }
            } else {
                //重置计数器
                count = 1;
                nums[++i] = nums[j];
            }
            j++;
        }

        //加上第一个元素
        return i + 1;
    }

    public static void main(String[] args) {
        Solution16 solution16 = new Solution16();
        int[] nums = {/*0, 0,*/ 1, 1, 1, 1, 2, 3, 3};
        int i = solution16.removeDuplicates(nums);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));
    }
}
