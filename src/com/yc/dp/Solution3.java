package com.yc.dp;

public class Solution3 {//三步问题
    final static int mod = 1000000007;

    public static int waysToStep(int n) {
        switch (n) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 4;
            default:
                break;
        }
        int[] result = new int[n];
        result[0] = 1;
        result[1] = 2;
        result[2] = 4;
        for (int i = 3; i < n; i++) {
            result[i] = ((result[i - 3] % mod + result[i - 2] % mod) % mod + result[i - 1] % mod) % mod;
        }
        return result[n - 1];
    }

    public static void main(String[] args) {
        int i = waysToStep(5);
        System.out.println(i);
    }
}
