package com.yc.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution6 {//复原ip地址⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐
    List<String> result = new ArrayList();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }

        //中间量
        List<String> path = new ArrayList<>();
        dfs(s, 0, 0, path);
        return result;
    }

    private int judgeIfIpSegment(String s, int left, int right) {
        int len = right - left + 1;

        //大于 1 位的时候，不能以 0 开头
        if (len > 1 && s.charAt(left) == '0') {
            return -1;
        }

        //转成int类型,一个char字符-'0'可以转换成int类型
        int res = 0;
        for (int i = left; i <= right; i++) {
            res = res * 10 + s.charAt(i) - '0';
        }

        return res > 255 ? -1 : res;//超过255返回-1*/
    }

    /**
     * @param s           传入的字符串
     * @param splitCounts 已经分割出多少个ip段
     * @param begin       截取ip段的起始位置
     * @param path        记录从根结点到叶子结点的一个路径(回溯算法常规变量)
     */
    private void dfs(String s, int splitCounts, int begin, List<String> path) {
        if (splitCounts == 4) {
            if (begin == s.length()) {
                result.add(String.join(".", path));
            } else return;
        }

        //判断剩下的够不够,否则就退出(剪枝)⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐
        //len-begin表示剩余的还未分割的字符串的位数,最小长度为1,最大长度为3
        if (s.length() - begin < (4 - splitCounts) || s.length() - begin > 3 * (4 - splitCounts)) {
            return;
        }

        for (int i = begin; i < begin + 3; i++) {
            if (i >= s.length()) {
                break;
            }

            int ipSegment = judgeIfIpSegment(s, begin, i);
            if (ipSegment != -1) {
                //在判断是ip段的情况下,才去做截取,转换成字符串,并添加到path中
                path.add(ipSegment + "");
                dfs(s, splitCounts + 1, i + 1, path);
                path.remove(path.size() - 1);//移除末尾元素进行下一轮循环
            }
        }
    }

    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        List<String> list = solution6.restoreIpAddresses(new String("25525511135"));
        //List<String> list = solution5.restoreIpAddresses(new String("0000"));rn;
        System.out.println(list);
    }
}
