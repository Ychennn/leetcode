package com.yc.array;

public class Solution21 {//在D天内送达包裹的能力

    public static int shipWithinDays(int[] weights, int D) {
        int max = 0;//最大承载力
        int min = weights[0];//最小承载力
        for (int weight : weights) {
            max += weight;
            if (weight > min) {
                min = weight;
            }
        }

        while (min < max) {
            int mid = min + (max - min) / 2;
            if (canShip(weights, D, mid)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    private static boolean canShip(int[] weights, int D, int K) {
        int sum = 0;
        for (int weight : weights) {
            sum += weight;
            if (sum > K) {
                sum = weight;
                D--;
            }
        }
        return D > 0;// 能否在D天内运完
    }

    public static void main(String[] args) {
        int i = shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3);
        System.out.println(i);

    }
}
