package com.yc.offer_medium;

import java.util.Arrays;

public class Solution3 {//把数组排成最小的数⭐⭐⭐⭐

    public String minNumber(int[] nums) {
        String[] strArr = new String[nums.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strArr, (str1, str2) ->
                (str1 + str2).compareTo(str2 + str1));

        StringBuilder res = new StringBuilder();
        for (String str : strArr) {
            res.append(str);
        }
        return res.toString();
    }
}
