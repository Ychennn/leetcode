package com.yc.top_medium;

import java.util.Random;

public class Solution13 {//打乱数组⭐⭐⭐⭐⭐
    private int[] arr;
    private int[] original;//记录初始数组
    private Random random;

    //也可以使用List,不断的从剩余的list中获取元素(效率低)
    public Solution13(int[] nums) {
        arr = nums;
        original = arr.clone();
        random = new Random();
    }

    public int[] reset() {//重置数组
        arr = original.clone();
        return arr;
    }

    private int getRandomIdx(int min, int max) {//获取随机索引
        return min + random.nextInt(max - min);
    }

    private void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }

    public int[] shuffle() {//洗牌算法,必须满足打乱共有n!种可能(n==arr.length),且可能性相等
        for (int i = 0; i < arr.length; i++) {
            //每次获取的随机索引为当前索引往后,必须包括自己,才能满足n!种可能
            //如n=5,第一次getRandomIdx可能的的值为{0,1,2,3,4},以此类推
            swap(arr, i, getRandomIdx(i, arr.length));
        }
        return arr;
    }
}
