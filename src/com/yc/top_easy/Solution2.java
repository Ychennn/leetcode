package com.yc.top_easy;

import java.util.Arrays;

public class Solution2 {//计数质数⭐⭐⭐⭐⭐⭐

    public int countPrimes(int n) {//统计小于n的质数的个数
        if (n < 3) return 0;
        boolean[] isPrime = new boolean[n];//标记是否为质数
        Arrays.fill(isPrime, true);

        int count = 0;//质数的个数
        for (int i = 2; i * i < n; i++) {//i * i < n
            if (isPrime[i]) {
                //i的倍数不可能是素数了
                for (int j = i * i; j < n; j += i)//⭐⭐⭐画图(去除重复)
                    isPrime[j] = false;
            }
        }

        for (int i = 2; i < n; i++) {
            count += isPrime[i] ? 1 : 0;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int i = solution2.countPrimes(10);
        System.out.println(i);
    }
}
