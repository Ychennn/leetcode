package com.yc.bit;

public class Solution17 {//最大数值⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int maximum(int a, int b) {
        //这步为获取两数相减的符号位,因为可能为2个负数,int溢出
        //使用long型,在运算后右移并进行int类型强转获取符号位
        int flag = (int) ((((long) a - (long) b) >>> 63) & 1);
        return b * flag + a * (flag ^ 1);
    }
}
