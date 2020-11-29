package com.yc.hot100;

import java.util.*;

public class Solution11 {//字母异位词分组⭐⭐⭐⭐

    public List<List<String>> groupAnagrams(String[] strs) {//hash
        if (strs == null || strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String s = String.valueOf(arr);//不能使用toString来转换
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList());
            }
            map.get(s).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = solution11.groupAnagrams(strs);
        System.out.println(list);
    }
}
