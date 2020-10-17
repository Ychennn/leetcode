package com.yc.bit;

import java.util.Arrays;

public class Solution22 {//只出现一次的数字3⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int[] singleNumber(int[] nums) {
        //核心思想在于用diff将数组分为2组,2个只出现一次的数字
        //分别在这2组中,然后再用异或求出即为解
        int diff = 0;

        for (int num : nums) {
            diff ^= num;
        }//此时diff为(2个只出现一次的数字)的异或的值,为1的地方即为不同


        //这一步在于获取最右边的1,其他全部置为0,便于下面的数组分离
        //只要能将diff改为二进制只包含一个1的值的方式都可以
        diff &= (-diff);

        int[] res = new int[2];
        for (int num : nums) {
            if ((diff & num) == 0) {
                res[0] ^= num;
            } else {//else部分可优化掉
                res[1] ^= num;
            }
        }

        //这里可以优化将for循环获取的diff保存为tmp_diff,此时diff == tmp_diff == res[0] ^ res[1]
        //res[1] = res[0]^tmpDiff;
        return res;
    }

    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        int[] nums = {1, 2, 1, 3, 2, 5};
        int[] res = solution22.singleNumber(nums);
        System.out.println(Arrays.toString(res));
    }
}
