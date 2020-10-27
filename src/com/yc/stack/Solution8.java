package com.yc.stack;

import java.util.ArrayList;
import java.util.List;

public class Solution8 {//用栈操作构建数组⭐⭐⭐⭐⭐⭐

    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();//代码更简洁
        int curr = 1;
        for (int i : target) {
            while (curr < i) {
                res.add("Push");
                res.add("Pop");
            }
            res.add("Push");
        }
        return res;
    }

    public static void main(String[] args) {
        Solution8 solution8 = new Solution8();
        int[] target = {1, 3};
        int n = 3;
        List<String> list = solution8.buildArray(target, n);
        System.out.println(list);
    }
}
