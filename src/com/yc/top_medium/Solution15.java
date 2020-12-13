package com.yc.top_medium;

import java.util.HashMap;
import java.util.Map;

public class Solution15 {//四数相加2⭐⭐⭐⭐⭐

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int a : A) {
            for (int b : B) {
                map.put(a + b, map.getOrDefault(a + b, 0) + 1);
            }
        }

        int res = 0;
        for (int c : C) {
            for (int d : D) {
                int sum = -(c + d);
                if (map.containsKey(sum)) res += map.get(sum);
            }
        }
        return res;
    }
}
