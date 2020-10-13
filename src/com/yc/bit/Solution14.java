package com.yc.bit;

public class Solution14 {//交替位二进制数⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public boolean hasAlternatingBits(int n) {
        //如果n为符合规定的数,错位之后相异或结果一定为全1
        int tmp = n ^ (n >> 1);//题目规定正整数
        //再与自己加1的值相与结果肯定为0
        return (tmp & tmp + 1) == 0;
    }

    public boolean hasAlternatingBits2(int n) {//逐位进行比较
        int pre = n & 1;//记录前一个二进制位(0\1)
        n >>>= 1;
        while (n != 0) {
            //如果连续两个二进制位相等,返回false
            if ((n & 1) == pre) return false;
            pre = n & 1;
            n >>= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution14 solution14 = new Solution14();
        boolean b = solution14.hasAlternatingBits(3);
        System.out.println(b);
    }
}
