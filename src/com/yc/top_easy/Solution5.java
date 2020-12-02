package com.yc.top_easy;

public class Solution5 {//阶乘后的零⭐⭐⭐⭐⭐

    //转变为求阶乘中5的个数,即为零的个数
    //如 5! = 1 * 2 * 3 * 4 * 5,count = 1;
    //13 ! = 1 * ... 5 * ... * (2*5) * 11 * 12 * 13,count = 2;
    //每隔5位会多一个5,每隔25位又会多个5
    //如 (1*5) * ... * 2*5 *... * (5*5),同理125位会额外再多一个5
    //求出5的个数
    public int trailingZeroes(int n) {
        int count = 0;
        int i = 5;
        while (i <= n) {
            count += n / i;
            i *= 5;
        }
        return count;
    }

    public int trailingZeroes2(int n) {//2个方法一样,写法不同
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        int i = solution5.trailingZeroes(13);
        System.out.println(i);
    }
}
