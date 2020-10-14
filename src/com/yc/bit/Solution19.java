package com.yc.bit;

public class Solution19 {//数字的补数⭐⭐⭐⭐⭐⭐

    public int findComplement(int num) {
        int tmp = num;

        int count = 0;//获取二进制的位数
        while (tmp != 0) {
            count++;
            tmp >>= 1;
        }

        //将原数与对应位全为1的数异或即为解
        return num ^ ((1 << count) - 1);
    }

    public int findComplement2(int num) {//和上面的方法思路一样,解法不同
        int tmp = 1;
        while (tmp < num) {
            tmp <<= 1;
            tmp += 1;
        }
        return tmp ^ num;
    }

    public static void main(String[] args) {
        Solution19 solution19 = new Solution19();
        int i = solution19.findComplement2(5);
        System.out.println(i);
    }
}
