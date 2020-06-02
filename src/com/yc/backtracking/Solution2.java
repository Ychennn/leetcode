package com.yc.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {//二进制手表
    List<String> result = new ArrayList();

    public List<String> readBinaryWatch(int num) {//未采用回溯
        if (num < 0 || num > 10) {
            return result;
        }
        for (int i = 0; i < 12; i++) {//遍历所有
            for (int j = 0; j < 60; j++) {
                if ((count(i) + count(j) == num)) {
                    result.add(j > 9 ? i + ":" + j : i + ":0" + j);
                }
            }
        }
        return result;
    }

    private int count(int n) {//统计n的二进制1的个数
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        List<String> list = solution2.readBinaryWatch(0);
        System.out.println(list);
    }
}
