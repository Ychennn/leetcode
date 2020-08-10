package com.yc.binarysearch;

public class Solution5 {//寻找比目标字母大的最小字母⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (letters[mid] > target) right = mid - 1;
            else left = mid + 1;
        }

        //取模是因为left=mid+1,可能会出现left>letters.length-1
        //满足了如果最小值都比target大需返回第一个元素的情况
        return letters[left % letters.length];
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        char[] letters = new char[]{'c', 'f', 'g'};
        char target = 'c';
        char c = solution5.nextGreatestLetter(letters, target);
        System.out.println(c);
    }
}
