package com.yc.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution13 {//完全平方数⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int numSquares(int n) {//动态规划⭐⭐⭐⭐
        int[] dp = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            dp[i] = i;

            for (int j = 1; i - j * j >= 0; j++) {
                //动态转换方程
                dp[i] = Math.max(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public int numSquares2(int n) {//bfs⭐⭐⭐⭐
        Queue<Integer> queue = new LinkedList<>();
        //标记元素是否已经添加过,防止重复计算,能大幅提高效率
        HashSet<Integer> visited = new HashSet<>();

        queue.add(n);

        int result = 0;
        while (!queue.isEmpty()) {
            result++;

            for (int i = queue.size(); i > 0; i--) {
                Integer curr = queue.poll();

                for (int j = 1; j * j <= curr; j++) {
                    int next = curr - j * j;

                    if (next == 0) return result;

                    if (!visited.contains(next)) {//如 12->11->10->6 ||  12->11->7->6
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
        }

        return result;
    }
}
