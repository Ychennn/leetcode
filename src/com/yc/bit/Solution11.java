package com.yc.bit;

public class Solution11 {//配对交换⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int exchangeBits(int num) {
        //分离奇数,如1010 -> 0000
        int odd = num & 0x55555555;
        //偶数1010 -> 1010
        int even = num & 0xaaaaaaaa;
        //0000
        odd <<= 1;
        //0101
        even >>= 1;
        return odd | even;
    }

    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        int i = solution11.exchangeBits(10);
        System.out.println(i);
    }
}
