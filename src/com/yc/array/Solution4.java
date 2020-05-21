package com.yc.array;

public class Solution4 {//最佳观光组合
    public static int maxScoreSightseeingPair(int[] A) {
        int max = 0;
        int first = A[0]+0;
        for (int i = 1; i < A.length; i++) {
            if(first+A[i]-i>max){
                max = first+A[i]-i;
            }
            first = Math.max(first,A[i]+i);
        }
        return max;
    }

    public static void main(String[] args) {
        int i = maxScoreSightseeingPair(new int[]{8,1, 5, 2, 6});
        System.out.println(i);
    }
}