package com.yc.top_medium;

import java.util.Arrays;

public class Solution4 {//摆动排序2

    public void wiggleSort(int[] nums) {
        //将数组排序,倒序的从排序后的数组取值放入
        //必须为逆序,如{4,5,5,6} 顺序 --> {4,5,5,6}
        //倒序 -->{5,6,4,5};
        int[] tmpArr = nums.clone();
        Arrays.sort(tmpArr);

        //如果nums.length为奇数则取中间的索引,如果为偶数,取中间靠左的索引
        //如nums.length==5,j取2,如果nums.length==4,j取1
        int j = (nums.length + 1) / 2 - 1;
        int k = nums.length - 1;

        //交替的取值,奇数索引取大值,偶数取小值(逆序)
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (i % 2 == 0 ? tmpArr[j--] : tmpArr[k--]);
        }
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int[] nums = {1, 2, 3, 4, 5};
        solution4.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
