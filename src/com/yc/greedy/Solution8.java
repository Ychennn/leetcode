package com.yc.greedy;

import java.util.Arrays;

public class Solution8 {//分发饼干

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;//已分配出的的饼干数
        int index = 0;//当前使用的饼干下标
        for (int i = 0; i < g.length; i++) {
            while (index < s.length) {
                if (s[index] >= g[i]) {
                    count++;
                    index++;//当该饼干能分配时,count++&index++并且退出当前循环
                    break;
                }
                index++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution8 solution8 = new Solution8();
        int[] g = new int[]{10, 9, 8, 7};
        int[] s = new int[]{5, 6, 7, 8};
        int children = solution8.findContentChildren(g, s);
        System.out.println(children);
    }
}
