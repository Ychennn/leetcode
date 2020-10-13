package com.yc.bit;

public class Solution15 {//4的幂⭐⭐⭐⭐⭐⭐⭐

    public boolean isPowerOfFour(int num) {
        //return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0xaaaaaaaa) == 0);
        return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0x55555555) != 0);
        //依次判断是否为正数,是否为2的幂,最后再用位运算判断是否为4的幂
    }

    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        boolean b = solution15.isPowerOfFour(16);
        System.out.println(b);
    }
}
