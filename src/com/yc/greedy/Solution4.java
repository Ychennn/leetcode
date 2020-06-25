package com.yc.greedy;

import java.util.Arrays;

public class Solution4 {//两地调度

    public int twoCitySchedCost(int[][] costs) {
        int len = costs.length;
        int[] arr = new int[len];
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += costs[i][0];//假设全去A地
            arr[i] = costs[i][1] - costs[i][0];//记录同一个人去A地和B地花费之差
        }

        Arrays.sort(arr);//排序
        for (int i = 0; i < len / 2; i++) {
            sum += arr[i];//costs[i][0] + costs[i][1] - costs[i][0]就为去B地之后的花费
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int[][] costs = new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}};
        int i = solution4.twoCitySchedCost(costs);
        System.out.println(i);
    }
}
