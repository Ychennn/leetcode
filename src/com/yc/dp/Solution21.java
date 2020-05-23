package com.yc.dp;

import java.util.*;

public class Solution21 {//单词拆分
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {//必须为i <= s.length()，substring(j, i)为从j开始截止到i前
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;//优化，防止如找ab，找到了继续寻找
                }
            }
        }
        return dp[s.length()];
    }


    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("apple");
        arrayList.add("pen");//该题意为能不能把给定的字符串，拆分为都在wordDict集合中
        boolean leetcode = wordBreak("applepenapple", arrayList);
        System.out.println(leetcode);
    }
}
