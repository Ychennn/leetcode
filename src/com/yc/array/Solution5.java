package com.yc.array;

public class Solution5 {//行相等的最少多米诺选择

    private static int check(int[] A, int[] B, int val, int n) {
        int rotationsA = 0, rotationsB = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] != val && B[i] != val) return -1;
            else if (A[i] != val) rotationsA++;
            else if (B[i] != val) rotationsB++;//不能直接else，否者两数相等也会交换，造成+1。
        }
        return Math.min(rotationsA, rotationsB);
    }

    public static int minDominoRotations(int[] A, int[] B) {
        int n = A.length;
        int rotations = check(A, B, A[0], n);
        if (rotations != -1 || A[0] == B[0]) return rotations;
        else return check(A, B, B[0], n);
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 1, 1, 1, 2, 2, 2};
        int[] B = new int[]{2, 1, 2, 2, 2, 2, 2, 2};
        int i = minDominoRotations(A, B);
        System.out.println(i);
    }
}
