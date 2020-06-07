package com.yc.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution8 {//格雷编码

    //设 nn阶格雷码集合为G(n),则G(n+1)阶格雷码为:
    //给 G(n)阶格雷码每个元素二进制形式前面添加0,得到G'(n)
    //设 G(n)合倒序(镜像)为 R(n),给 R(n)每个元素二进制形式前面添加1，得到 R'(n)
    //G(n+1)=G'(n)∪R'(n)拼接两个集合即可得到下一阶格雷码
    //如1 --> 0,1    2 --> 0,1,2+1,2+0
    public List<Integer> grayCode(int n) {//二进制
        List<Integer> res = new ArrayList<Integer>() {{
            add(0);
        }};//--->res.add(0);初始化n==0的值

        int head = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(head + res.get(j));
            }
            head <<= 1;//左移1位
        }
        return res;
    }

    public static void main(String[] args) {
        Solution8 solution8 = new Solution8();
        List<Integer> list = solution8.grayCode(2);
        System.out.println(list);
    }
}
