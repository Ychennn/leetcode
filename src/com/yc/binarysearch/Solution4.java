package com.yc.binarysearch;


import java.util.Arrays;

public class Solution4 {//供暖器

    public int findRadius(int[] houses, int[] heaters) {
        //在每个房子附近找出最小的暖器距离,在所有距离中取最大的距离
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int res = 0;
        int right = 0;
        for (int house : houses) {
            //right + 1 < heaters.length,这一步是找到第一个大于该房间位置的供暖器
            while (right + 1 < heaters.length && heaters[right] < house) {
                right++;
            }
            //特殊处理,防止right-1越界
            if (right == 0) res = Math.max(res, Math.abs(house - heaters[right]));
            else res = Math.max(res, Math.min(Math.abs(house - heaters[right]),
                    Math.abs(house - heaters[right - 1])));
        }

        return res;
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int[] houses = new int[]{1, 2, 3, 4};
        int[] heaters = new int[]{1, 4};
        int i = solution4.findRadius(houses, heaters);
        System.out.println(i);
    }
}
