package com.yc.top_easy;

import java.util.ArrayList;
import java.util.List;

public class Solution14 {//杨辉三角

    public List<List<Integer>> generate(int numRows) {
        if (numRows < 1) return new ArrayList<>();//

        List<List<Integer>> res = new ArrayList<>();

        //初始化第一条链表,因为pre为前一条链表
        res.add(new ArrayList<>());
        res.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            //当前链表
            List<Integer> tmp = new ArrayList<>();
            //获取上一条链表
            List<Integer> pre = res.get(i - 1);

            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {//如果是边界则向tmp.add(1);
                    tmp.add(1);
                } else {
                    tmp.add(pre.get(j - 1) + pre.get(j));
                }
            }
            res.add(tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution14 solution14 = new Solution14();
        List<List<Integer>> lists = solution14.generate(5);
        System.out.println(lists);
    }
}
