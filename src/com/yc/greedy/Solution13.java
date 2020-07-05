package com.yc.greedy;

public class Solution13 {//拼车⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public boolean carPooling(int[][] trips, int capacity) {
        //trips.length <= 1000
        int[] allTrips = new int[10001];

        for (int i = 0; i < trips.length; i++) {
            for (int j = trips[i][1]; j < trips[i][2]; j++) {
                allTrips[j] += trips[i][0];
                if (allTrips[j] > capacity) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean carPooling2(int[][] trips, int capacity) {//优化
        //trips.length <= 1000
        int[] allTrips = new int[10001];

        //直接记录上下车的容量变化情况,如 ---> {{2, 1, 5}, {3, 3, 7}}
        //在1号站上车2人减去容量2,又在3号站上车3人减去容量3
        //在5号站下车2人增加容量2,又在7号站下车3人增加容量3
        //从0号站开始遍历,如果该站台和目前的容量相加<0,不满足条件,返回false
        for (int i = 0; i < trips.length; i++) {
            allTrips[trips[i][1]] -= trips[i][0];
            allTrips[trips[i][2]] += trips[i][0];
        }

        for (int j = 0; j < allTrips.length; j++) {
            capacity += allTrips[j];
            if (capacity < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution13 solution13 = new Solution13();
        int[][] trips = new int[][]{{2, 1, 5}, {3, 3, 7}};
        int capacity = 4;
        boolean b = solution13.carPooling2(trips, capacity);
        System.out.println(b);
    }
}
