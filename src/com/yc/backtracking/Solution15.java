package com.yc.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution15 {//分割回文串
    List<List<String>> result = new ArrayList();

    public List<List<String>> partition(String s) {
        List<String> list = new ArrayList<>();
        recursion(s, 0, list);
        return result;
    }

    private void recursion(String str, int start, List<String> list) {
        if (start == str.length()) {
            result.add(new ArrayList(list));
            return;
        }

        for (int i = start; i < str.length(); i++) {
            if (isPartition(str, start, i)) {//如果截取的子串为回文子串,进入当前步骤
                //因为substring(lindex,rindex)是从lindex截取到rindex不包含rindex
                //所以i+1
                list.add(str.substring(start, i + 1));

                recursion(str, i + 1, list);//递归调用

                //撤销当前操作
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPartition(String str, int left, int right) {//判断截取的字符串是否为回文串
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        List<List<String>> aba = solution15.partition("aab");
        System.out.println(aba);
    }
}