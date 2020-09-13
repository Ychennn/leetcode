package com.yc.dpointer;

import java.util.Arrays;

public class Solution23 {//最小差

    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        int aIndex = 0;
        int bIndex = 0;

        int res = Integer.MIN_VALUE;
        while (aIndex < a.length && bIndex < b.length) {

            //因为负数的范围比证书的范围大,转换为负数能避免溢出
            res = Math.max(res, -Math.abs(a[aIndex] - b[bIndex]));
            if (a[aIndex] < b[bIndex]) aIndex++;
            else bIndex++;
        }

        return -res;
    }

    public static void main(String[] args) {
        Solution23 solution23 = new Solution23();
        int[] a = {-2147483648, 1};
        int[] b = {2147483647, 0};
        int i = solution23.smallestDifference(a, b);
        System.out.println(i);
    }
}
