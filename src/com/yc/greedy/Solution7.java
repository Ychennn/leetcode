package com.yc.greedy;

import java.util.Arrays;

public class Solution7 {//最后一块石头的重量⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int lastStoneWeight(int[] stones) {
        int index = stones.length - 1;//被操作数据的下标
        for (int i = 0; i < stones.length - 1; i++) {
            Arrays.sort(stones);
            if (stones[index - 1] == 0) break;//第二大数为0,说明已经完成,如{1, 3, 3}可减少循环次数

            stones[index] -= stones[index - 1];//两种不同情况都使用以下表达式处理⭐⭐⭐
            stones[index - 1] = 0;
        }
        return stones[index];
    }

    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        int[] stones = {1, 1, 3};
//        int[] stones = {1, 1};
//        int[] stones = {1, 2, 3};
        int i = solution7.lastStoneWeight(stones);
        System.out.println(i);
    }
}
