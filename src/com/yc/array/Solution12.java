package com.yc.array;

public class Solution12 {//总持续时间可被60整除的歌曲

    public static int numPairsDivisibleBy60(int[] time) {
        int[] seconds = new int[60];
        for (int i : time) {
            seconds[i % 60]++;
        }//即任意两首歌加起来能整除60.
        int count = 0;
        for (int i = 0; i <= 30; i++) {
            if (i == 0 || i == 30) {
                count += (seconds[i] * (seconds[i] - 1)) / 2;
            } else {
                count += seconds[i] * seconds[60 - i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int i = numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40});
        System.out.println(i);
    }
}