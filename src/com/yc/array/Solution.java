package com.yc.array;

public class Solution {//盛水最多的容器

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left != right) {
            if (height[left] >= height[right]) {
                if ((height[right] * (right - left)) > maxArea) {
                    maxArea = height[right] * (right - left);
                }
                right--;
            } else {
                if (height[left] * (right - left) > maxArea) {
                    maxArea = height[left] * (right - left);
                }
                left++;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = maxArea(height);
        System.out.println("最多盛水：" + maxArea);
    }
}