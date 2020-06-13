package com.yc.greedy;

public class Solution2 {//玩筹码

    public int minCostToMoveChips(int[] chips) {
        int odd = 0;
        int even = 0;
        //chips[i]代表第i号筹码在chips[i]对应值的位置上
        for (int i = 0; i < chips.length; i++) {
            if (i % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return Math.min(odd, even);
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int i = solution2.minCostToMoveChips(new int[]{1, 2, 3});
        System.out.println(i);
    }
}
