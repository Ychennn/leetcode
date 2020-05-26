package com.yc.dp;

public class Solution24 {//剪绳子

    public static int cuttingRope(int n) {//数学推导,最优的绳段长度为 3。
        if (n <= 3) return n - 1;
        /*最优：3。把绳子尽可能切为多个长度为 3 的片段，留下的最后一段绳子的长度可能为0,1,2三种情况。
        次优：2。若最后一段绳子长度为 2；则保留，不再拆为1+1 。
        最差：1。若最后一段绳子长度为 1；则应把一份3+1替换为 2+2，因为 2*2>3*1。*/
        if (n % 3 == 0) return (int) Math.pow(3, n / 3);
        if (n % 3 == 1) return (int) Math.pow(3, n / 3 - 1) * 4;
        return (int) Math.pow(3, n / 3) * 2;
    }

    public static void main(String[] args) {
        int i = cuttingRope(120);
        System.out.println(i);
    }
}
