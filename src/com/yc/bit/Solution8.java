package com.yc.bit;

public class Solution8 {//位1的个数⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            //必须使用无符号右移,否则会出现死循环
            //如 -1 右移之后还是-1
            n >>>= 1;
        }
        return count;
    }

    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Solution8 solution8 = new Solution8();
        //Java中编译器使用二进制补码记法来表示有符号整数,所有-1有32个1
        int i = solution8.hammingWeight2(-1);
        System.out.println(i);
    }
}
