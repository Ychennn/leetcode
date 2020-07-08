package com.yc.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution18 {//划分字母区间

    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];//记录每个字母最后一次出现的位置
        for (int i = 0; i < S.length(); ++i) {
            last[S.charAt(i) - 'a'] = i;
        }

        int start = 0;//记录起始位置
        int end = 0;//记录结束位置

        List<Integer> result = new ArrayList();
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (i == end) {
                result.add(i - start + 1);
                start = i + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution18 solution18 = new Solution18();
        String S = "ababcbacadefegdehijhklij";
        List<Integer> list = solution18.partitionLabels(S);
        System.out.println(list);
    }
}
