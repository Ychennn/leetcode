package com.yc.bit;

public class Solution16 {//汉明距离

    public int hammingDistance(int x, int y) {
        int num = x ^ y;
        int count = 0;
        while (num != 0) {
            count += (num & 1);
            num >>>= 1;
        }
        //统计两个数字对应二进制位不同的位置的数目
        return count;
    }

    public static void main(String[] args) {
        Solution16 solution16 = new Solution16();
        int i = solution16.hammingDistance(1, 4);
        System.out.println(i);
    }
}
