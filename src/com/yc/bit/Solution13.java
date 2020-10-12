package com.yc.bit;

public class Solution13 {//颠倒二进制位⭐⭐⭐⭐⭐⭐⭐

    public int reverseBits(int n) {//取模求和
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1) + (n & 1);
            n >>>= 1;
        }
        return res;
    }

    public int reverseBits2(int n) {//按位反转
        int res = 0;
        for (int i = 0; i < 32; i++) {
            //res += (n & (1 << i)) != 0 ? 1 << (31 - i) : 0;
            //res |= (n & (1 << i)) != 0 ? 1 << (31 - i) : 0;

            //未进行任何操作前对应位肯定为0,异或也能完成 += 或 |= 的效果
            res ^= (n & (1 << i)) != 0 ? 1 << (31 - i) : 0;
        }
        return res;
    }

    public int reverseBits3(int n) {//分治⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐
        n = (n >>> 16) | (n << 16);//必须为无符号右移,否则负数高位补0,会出错
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        return n;
    }

    public static void main(String[] args) {
        Solution13 solution13 = new Solution13();
        int i = solution13.reverseBits3(-1);
        System.out.println(i);
    }
}
