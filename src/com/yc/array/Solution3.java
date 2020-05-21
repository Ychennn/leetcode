package com.yc.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3 {//三数之和

    public static List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        int left;
        int right;
        int sum;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] <= 0) {
                if (i > 0 && nums[i] == nums[i - 1]) continue;//防止-2，-2...
                left = i + 1;
                right = nums.length - 1;
                while (left < right) {
                    sum = nums[i] + nums[left] + nums[right];
                    if (sum > 0) {
                        right--;
                    } else if (sum < 0) {
                        left++;
                    } else {
                        lists.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++; // 去重,防止-2，-1，-1，-1
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--; // 去重
                        }
                        left++;
                        right--;
                    }
                }
            } else {
                break;
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum(new int[]{1, -1, -1, 0});
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
