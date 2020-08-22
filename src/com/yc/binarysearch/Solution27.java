package com.yc.binarysearch;

public class Solution27 {//爱吃香蕉的珂珂

    public int minEatingSpeed(int[] piles, int H) {
        int left = 0;
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (helper(piles, H, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean helper(int[] piles, int H, int K) {
        int count = 0;
        for (int pile : piles) {
            //向上取整,必须*1.0否则不能达到效果
            count += Math.ceil(pile * 1.0 / K);
        }
        return count <= H;
    }

    public static void main(String[] args) {
        Solution27 solution27 = new Solution27();
        int[] piles = new int[]{3, 6, 7, 11};
        int H = 8;
        int i = solution27.minEatingSpeed(piles, H);
        System.out.println(i);
    }
}
