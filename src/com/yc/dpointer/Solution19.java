package com.yc.dpointer;

public class Solution19 {//统计「优美子数组」⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int numberOfSubarrays(int[] nums, int k) {//双指针
        int left = 0;//左指针
        int right = 0;//右指针
        int count = 0;//区间内奇数个数
        int res = 0;//返回结果

        while (right < nums.length) {
            if (count < k) {
                //右指针先走,每遇到一个奇数则count++
                if ((nums[right] & 1) != 0) {
                    count++;
                }
                right++;
            }

            if (count == k) {
                int tmp = right;

                while (right < nums.length && (nums[right] & 1) == 0) {
                    right++;
                }

                int rightEvenCount = right - tmp;

                int leftEvenCnt = 0;
                while ((nums[left] & 1) == 0) {
                    leftEvenCnt++;
                    left++;
                }

                res += (leftEvenCnt + 1) * (rightEvenCount + 1);

                //此时left指向的是第1个奇数,因为该区间已经统计完了,因此left右移一位,oddCnt--
                left++;
                count--;
            }
        }
        return res;
    }

    public int numberOfSubarrays2(int[] nums, int k) {//前缀和
        //定义数组,下标是前缀奇数的个数,值是出现的次数
        int[] prefixCount = new int[nums.length + 1];
        //初始化当前角标前面有0个奇数的情况出现一次
        prefixCount[0] = 1;
        int res = 0;
        int sum = 0;
        for (int num : nums) {
            //每遇到一个奇数则个数+1
            sum += num & 1;
            //每遇到一个偶数则出现次数+1
            prefixCount[sum]++;
            if (sum >= k) {
                //每次累加到当前位置k个奇数的出现次数
                res += prefixCount[sum - k];
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Solution19 solution19 = new Solution19();
        int[] nums = new int[]{1, 1, 2, 1, 1};
        int k = 3;
        int i = solution19.numberOfSubarrays2(nums, k);
        System.out.println(i);
    }
}
