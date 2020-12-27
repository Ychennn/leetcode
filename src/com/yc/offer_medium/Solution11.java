package com.yc.offer_medium;

public class Solution11 {//数字序列中某一位的数字⭐⭐⭐⭐⭐

    public int findNthDigit(int n) {
        if (n == 0) return 0;//题目要求

        int digit = 1;//数的位数
        long start = 1;//该数位的所有数的起始点数,digit=2 --> start = 10
        long count = 9;//该数位的所有的数的位数之和

        while (n > count) {//画图
            n -= count;
            start *= 10;
            digit++;
            count = digit * start * 9;
        }

        //算出索引n,属于的那个数
        long num = start + (n - 1) / digit;
        //将该数转换为字符串,求出n索引对应的数值
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }

    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        int i = solution11.findNthDigit(3);
        System.out.println(i);
    }
}
