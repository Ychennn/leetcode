package com.yc.hot100;

import java.util.*;

public class Solution6 {//前K个高频元素⭐⭐⭐⭐⭐⭐⭐

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //map用来存放各个数值及其出现次数
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //桶排序
        //将频率作为对应数组的索引,对于出现频率不同的数字集合,存入对应的数组下标
        List<Integer>[] list = new ArrayList[nums.length + 1];
        for (Integer num : map.keySet()) {
            int i = map.get(num);
            if (list[i] == null) list[i] = new ArrayList<>();
            list[i].add(num);
        }

        int[] res = new int[k];

        int idx = 0;
        //从索引高到低依次遍历每个桶,如果桶不空,则取数直至取出前k个数 --> (k--)>0
        for (int i = list.length - 1; i >= 0; i--) {
            if (list[i] == null) continue;
            for (int j = 0; j < list[i].size() && k-- > 0; j++) {
                res[idx++] = list[i].get(j);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        int[] nums = {4, 1, -1, 2, -1, 2, 3};
        int[] top = solution6.topKFrequent(nums, 2);
        System.out.println(Arrays.toString(top));
    }
}
