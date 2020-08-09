package com.yc.binarysearch;

public class Solution {//排列硬币

    public int arrangeCoins(int n) {//效率低
        int res = 0;
        long sum = 0;

        while (true) {
            res++;
            sum += res;
            if (sum >= n) break;
        }

        return sum == n ? res : res - 1;
    }

    public int arrangeCoins2(int n) {//数学法
        //正数解为 -> k = sqrt(2n+1/4) - 1/2,但2n+1/4有可能会超出sqrt函数的参数范围
        return (int) (Math.sqrt(2) * Math.sqrt(n + 1.0 / 8) - 1.0 / 2);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.arrangeCoins(6);
        System.out.println(1.0 / 8);
    }
}
