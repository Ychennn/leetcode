package com.yc.top_easy;

public class Solution4 {//最长公共前缀

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String res = strs[0];

        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            //j的范围为res和当前strs[i]的较小值
            for (; j < strs[i].length() && j < res.length(); j++) {
                if (res.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            res = res.substring(0, j);
            if (res.equals("")) return res;//提前返回
        }
        return res;
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        String[] strs = {"ab", "a"};
        String prefix = solution4.longestCommonPrefix(strs);
        System.out.println(prefix);
    }
}
