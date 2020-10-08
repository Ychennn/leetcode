package com.yc.bit;

public class Solution3 {//2的幂⭐⭐⭐⭐⭐⭐⭐⭐

    public boolean isPowerOfTwo(int n) {
        //2的幂,对应二进制只能有1个1,减一再相与结果就为0
        return n > 0 && (n & (n - 1)) == 0;
    }

    public boolean isPowerOfTwo2(int n) {
        if (n <= 0) return false;
        //n & (-n)将保留最右边的 1,并将其他的位设置为 0
        //此时再将结果只与原数相比较,相等则为2的幂
        return (n & (-n)) == n;
    }

    public boolean isPowerOfTwo3(int n) {
        if (n <= 0) return false;
        //统计二进制中1的个数
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>= 1;
        }
        return count == 1;
    }

    public boolean isPowerOfTwo4(int n) {//遍历法
        if (n <= 0) return false;
        int num = 1;
        for (int i = 0; i < 31; i++) {
            if (num == n) return true;
            num <<= 1;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        solution3.isPowerOfTwo4(16);
    }
}
