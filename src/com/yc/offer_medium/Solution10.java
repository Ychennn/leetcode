package com.yc.offer_medium;

public class Solution10 {//机器人的运动范围⭐⭐⭐⭐⭐
    boolean[][] isVisited;

    public int movingCount(int m, int n, int k) {
        isVisited = new boolean[m][n];
        // 机器人从[0,0]坐标开始移动
        return dfs(m, n, k, 0, 0);
    }

    public int dfs(int m, int n, int k, int x, int y) {//dfs
        //递归终止条件
        if ((get(x) + get(y) > k) || x < 0 || x >= m || y < 0 || y >= n || isVisited[x][y]) {
            return 0;
        }

        //将该格子标记为已经访问过
        isVisited[x][y] = true;
        //仅考虑向下和向右的移动方向就能遍历到矩阵的所有元素
        //不会漏掉(优化,不再是上,下,左,右)
        return 1 + dfs(m, n, k, x, y + 1)
                + dfs(m, n, k, x + 1, y);
    }

    //计算一个数的各个位数之和
    private int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }
}
