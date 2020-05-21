package com.yc.array;

public class Solution6 {//将数组分成和相等的三个部分

    public static boolean canThreePartsEqualSum(int[] A) {//方法一，比较暴力
        int sum = 0;
        for (int i : A) {
            sum += i;
        }
        if (sum % 3 != 0) {
            return false;
        }

        int count = 0;
        int sum2 = 0;
        for (int i = 0; i < A.length; i++) {
            sum2 += A[i];
            if (sum2 == sum / 3) {
                count++;
                sum2 = 0;
            }
        }
        if (count >= 3) {
            return true;
        }
        return false;
    }

    public static boolean canThreePartsEqualSum2(int[] A) {//双指针法
        int sum = 0;
        for (int i : A) {
            sum += i;
        }
        if (sum % 3 != 0) {
            return false;
        }

        int left = 0;
        int leftSum = A[left];
        int right = A.length - 1;
        int rightSum = A[right];
        while (left + 1 < right) {
            if (leftSum == sum / 3 && rightSum == sum / 3) {
                return true;
            }
            if (leftSum != sum / 3) {//不能用<或>做判断条件
                leftSum += A[++left];
            }
            if (rightSum != sum / 3) {
                rightSum += A[--right];
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean b = canThreePartsEqualSum2(new int[]{10, -10, 10, -10, 10, -10, 10, -10});
        System.out.println(b);
    }

}