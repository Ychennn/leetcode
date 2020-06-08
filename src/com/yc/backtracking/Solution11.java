package com.yc.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution11 {//括号生成
    List<String> result = new ArrayList();

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return result;
        }
        dfs("", n, n);
        return result;
    }

    /**
     * @param currStr 当前的字符串(已经添加了'('和')')
     * @param left    左括号剩余可用数
     * @param right   右括号剩余可用数
     *                该方法也可以改为加法,方法参数需再加个n,n即为括号要求使用的数量
     */
    private void dfs(String currStr, int left, int right) {//深度优先遍历

        if (left == 0 && right == 0) {//当左右括号都使用完,将结果加入result,并结束递归
            result.add(currStr);//
        }

        if (left > right) {//当左边括号可使用数>右边,直接返回
            return;//如n=2,先使用右括号right=1,left=2结果是不满足的直接返回
            //又如n=2,此时currStr为"()",left=1&right=1,再使用右括号,left=1,right=0,不满足直接返回
        }

        if (left > 0) {
            dfs(currStr + "(", left - 1, right);
        }

        if (right > 0) {
            dfs(currStr + ")", left, right - 1);
        }
    }

    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        List<String> list = solution11.generateParenthesis(3);
        System.out.println(list);
    }
}