package com.yc.dac;

import java.util.Arrays;

public class Solution3 {//最小的k个数

    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }
}