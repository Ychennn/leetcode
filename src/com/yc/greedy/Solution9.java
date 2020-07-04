package com.yc.greedy;

import java.util.Arrays;

public class Solution9 {//K 次取反后最大化的数组和⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int largestSumAfterKNegations(int[] A, int K) {//多次排序,效率低
        for (int i = 0; i < K; i++) {
            Arrays.sort(A);
            A[0] = -A[0];
        }

        int sum = 0;

        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        return sum;
    }

    public int largestSumAfterKNegations2(int[] A, int K) {//优化
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {//先把前面的负数全部取正
            if (A[i] < 0 && K > 0) {
                A[i] = -A[i];
                K--;
            }
        }

        Arrays.sort(A);//再次排序
        if (K % 2 != 0) {//如果剩余的次数K为偶数,就反复加减A[0]-->最终值不变
            A[0] = -A[0];//否者减去A[0]
        }

        int result = 0;
        for (int index : A) {
            result += index;
        }

        return result;
    }

    public int largestSumAfterKNegations3(int[] A, int K) {//再次优化,维护一个最小值索引
        Arrays.sort(A); //负数...0..0..正数
        int sum = 0;
        int len = A.length;
        int minIndex = 0; //最小值索引,初始第一个最小
        while (K > 0) {
            A[minIndex] = -A[minIndex]; //最小值取反
            K--;
            //维护最小值索引
            //若后面还有数,则看当前的与下一个谁更小
            if (minIndex + 1 < len && A[minIndex] > A[minIndex + 1]) {//如{-1,-2,3}&K>0 和 {1,2,3}&K>0
                minIndex++;
            }
        }
        for (int i : A) sum += i;
        return sum;
    }

    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
//        int[] A = new int[]{4, 2, 3};
        int[] A = new int[]{3, -1, 0, 2};
        int K = 3;
        int i = solution9.largestSumAfterKNegations(A, K);
        System.out.println(i);
    }
}
