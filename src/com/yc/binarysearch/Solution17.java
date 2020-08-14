package com.yc.binarysearch;

public class Solution17 {//旋转数组的最小数字⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        int mid;

        //这里可以为 < 也可以为 <= 区别在于多走一步流程,mid==left==right
        //符合else条件,最终left>right,right--仍返回left
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                //因为mid可能就是最小值,所以right=mid而不是mid-1
                right = mid;
            } else {
                right--;
            }
        }
        return numbers[left];
    }

    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        int[] numbers = new int[]{3, 2, 3};
        int i = solution17.minArray(numbers);
        System.out.println(i);
    }
}
