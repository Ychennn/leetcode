package com.yc.top_easy;

public class Solution {//整数反转⭐⭐⭐⭐⭐⭐⭐

    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int tmp = x % 10;

            //2个if处理,防止如1056389759反转后溢出int
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && tmp > 7))
                return 0;

            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && tmp < -8))
                return 0;

            res = res * 10 + tmp;
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.reverse(123);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(i);
    }
}
