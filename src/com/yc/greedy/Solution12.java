package com.yc.greedy;

public class Solution12 {//加油站⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int canCompleteCircuit(int[] gas, int[] cost) {//效率低
        for (int i = 0; i < gas.length; i++) {
            if (circuit(gas, cost, i, 0)) {
                return i;
            }
        }
        return -1;
    }

    private boolean circuit(int[] gas, int[] cost, int index, int curr) {
        for (int i = 0; i < gas.length; i++) {
            curr += gas[index];
            if (curr >= cost[index]) {
                curr -= cost[index];
                if (index == gas.length - 1) {
                    index = 0;
                } else {
                    index++;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {//贪心算法
        int total = 0;
        //所有加油站的油量-消耗累积和
        int curr = 0;
        //当前油量
        int start = 0;
        //初始化从0号加油站开始
        for (int i = 0; i < gas.length; i++) {
            curr += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (curr < 0) {
                //无法到达下一个加油站
                curr = 0;
                //油量清空
                start = i + 1;
                //将下一个加油站作为起点
            }
        }
        return total < 0 ? -1 : start;
    }

    public static void main(String[] args) {
        Solution12 solution12 = new Solution12();
//        int[] gas = new int[]{1, 2, 3, 4, 5};
//        int[] cost = new int[]{3, 4, 5, 1, 2};
        int[] gas = new int[]{2, 3, 4};
        int[] cost = new int[]{4, 4, 3};
        int i = solution12.canCompleteCircuit2(gas, cost);
        System.out.println(i);
    }
}