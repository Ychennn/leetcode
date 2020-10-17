package com.yc.bit;

import java.util.Arrays;

public class Solution21 {//交换数字⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int[] swapNumbers(int[] numbers) {
        numbers[0] ^= numbers[1];
        numbers[1] ^= numbers[0];
        numbers[0] ^= numbers[1];
        return numbers;
    }

    public int[] swapNumbers2(int[] numbers) {
        numbers[0] += numbers[1];
        numbers[1] = numbers[0] - numbers[1];
        numbers[0] -= numbers[1];
        return numbers;
    }

    public static void main(String[] args) {
        Solution21 solution21 = new Solution21();
        int[] numbers = {1, 2};
        int[] num = solution21.swapNumbers(numbers);
        System.out.println(Arrays.toString(num));
    }
}
