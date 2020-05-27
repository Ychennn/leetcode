package com.yc.dp;

import java.util.ArrayList;
import java.util.List;

public class Solution19 {//三角形最小路径和⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public static int minimumTotal(List<List<Integer>> triangle) {//动态规划
        //特别值处理
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        int row = triangle.size();//行
        int column = triangle.get(row - 1).size();//列
        int[][] dp = new int[row][column];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < row; i++) {//动态转换方程：dp[i][j]=min(dp[i-1][j],dp[i-1][j-1])+triangle[i][j]
            //对每一行的元素进行推导
            List<Integer> rows = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    // 最左端特殊处理
                    dp[i][j] = dp[i - 1][j] + rows.get(j);
                } else if (j == i) {
                    // 最右端特殊处理
                    dp[i][j] = dp[i - 1][j - 1] + rows.get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + rows.get(j);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        // dp最后一行记录了最小路径
        for (int i = 0; i < column; i++) {
            min = Math.min(min, dp[row - 1][i]);
        }
        return min;
    }


    public static int minimumTotal2(List<List<Integer>> triangle) {//动态规划-->空间优化
        //特别值处理
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        int row = triangle.size();//行
        int column = triangle.get(row - 1).size();//列
        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);

        // prev暂存dp[i-1][j-1],cur暂存dp[i-1][j]
        int prev = 0, cur;
        for (int i = 1; i < triangle.size(); i++) {
            //对每一行的元素进行推导
            List<Integer> rows = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                cur = dp[j];//将dp[i-1][j]值保存起来
                if (j == 0) {
                    // 最左端特殊处理
                    dp[j] = cur + rows.get(j);
                } else if (j == i) {
                    // 最右端特殊处理
                    dp[j] = prev + rows.get(j);
                } else {
                    dp[j] = Math.min(cur, prev) + rows.get(j);
                }
                prev = cur;
            }
        }

        int min = Integer.MAX_VALUE;
        // dp最后一行记录了最小路径
        for (int i = 0; i < column; i++) {
            min = Math.min(min, dp[i]);
        }
        return min;
    }


    public static int minimumTotal3(List<List<Integer>> triangle) {//自底向上可以少判断边界情况
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        // 加1可以不用初始化最后一行
        // 根据题意，行列值相同
        int[][] dp = new int[triangle.size() + 1][triangle.size() + 1];

        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> rows = triangle.get(i);
            for (int j = 0; j < rows.size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + rows.get(j);
            }
        }
        return dp[0][0];
    }

    public int minimumTotal4(List<List<Integer>> triangle) {//自底向上空间优化
        // 特判
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
//        // dp中记录了求第i行时，第i+1的最小路径和
//        int[] dp = new int[triangle.size() + 1];
//
//        for (int i = triangle.size() - 1; i >= 0; i--) {
//            List<Integer> rows = triangle.get(i);
//            for (int j = 0; j < rows.size(); j++) {
//                dp[j] = Math.min(dp[j], dp[j + 1]) + rows.get(j);
//            }
//        }
//        return dp[0];

        int[] dp = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> rows = triangle.get(i);
            for (int j = 0; j < rows.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + rows.get(j);
            }
        }
        return dp[0];
    }


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-1);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(3);
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(-1);
        list3.add(-3);
//        ArrayList<Integer> list4 = new ArrayList<>();
//        list4.add(4);
//        list4.add(1);
//        list4.add(8);
//        list4.add(3);

        List<List<Integer>> triangle = new ArrayList();
        triangle.add(list);
        triangle.add(list2);
        triangle.add(list3);
//        triangle.add(list4);
        int i = minimumTotal3(triangle);
        System.out.println(i);
    }
}
