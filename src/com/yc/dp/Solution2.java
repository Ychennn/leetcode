package com.yc.dp;

public class Solution2 {//除数博弈

    public boolean divisorGame(int N) {//归纳法
        return N % 2 == 0;
    }

    public boolean divisorGame2(int N) {//动态规划,效率不高，但实现了dp思想
        if (N == 1) return false;
        if (N == 2) return true;
        boolean[] result = new boolean[N + 1];
        result[1] = false;
        result[2] = true;
        for (int i = 3; i < N + 1; i++) {
            result[i] = false;
            for (int j = 1; j < i; j++) {
                if (i % j == 0 && !result[i - j]) {
                    result[i] = true;
                    break;
                }
            }
        }
        return result[N];
    }
}
