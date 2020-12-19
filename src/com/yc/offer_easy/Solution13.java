package com.yc.offer_easy;

import java.util.*;

public class Solution13 {//圆圈中最后剩下的数字⭐⭐⭐⭐⭐

    public int lastRemaining2(int n, int m) {//ArrayList模拟约瑟夫环,效率极低
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int idx = 0;
        while (n > 1) {//n充当list.size
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }

    public int lastRemaining(int n, int m) {//数学法,倒推
        int res = 0;//n=1时,肯定返回0

        for (int i = 2; i <= n; i++) {//从1倒推到n
            //res代表还剩n个数时,最终留下来的数的索引
            res = (res + m) % i;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution13 solution13 = new Solution13();
        int i = solution13.lastRemaining2(5, 3);
        System.out.println(i);
    }
}
