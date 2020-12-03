package com.yc.top_easy;

public class Solution9 {//外观数列⭐⭐⭐⭐⭐⭐

    public String countAndSay(int n) {//双指针
        //递归终止条件
        if (n == 1) return "1";

        //获取上1层处理的结果,如n=2,countAndSay(1)返回"1"
        String pre = countAndSay(n - 1);
        StringBuffer res = new StringBuffer();
        //左指针
        int start = 0;

        //i右指针
        for (int i = 1; i < pre.length() + 1; i++) {//注意i的范围
            if (i == pre.length()) {
                res.append(i - start);//先追加出现的个数,如pre="21",先添加1代表一个"2"
                res.append(pre.charAt(start));//后追加出现的数,即"2"
            } else if (pre.charAt(i) != pre.charAt(start)) {
                res.append(i - start);//同理
                res.append(pre.charAt(start));
                start = i;//更新左指针
            }
        }

        return new String(res);
    }

    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
        String str = solution9.countAndSay(3);
        System.out.println(str);
    }
}
