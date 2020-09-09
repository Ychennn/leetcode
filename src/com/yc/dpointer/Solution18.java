package com.yc.dpointer;

public class Solution18 {//寻找重复数⭐⭐⭐⭐⭐⭐⭐⭐

    public int findDuplicate(int[] nums) {//快慢指针
        int slow = 0;
        int fast = 0;

        slow = nums[slow];
        fast = nums[nums[fast]];

        //寻找相遇点
        while (slow != fast) {
            slow = nums[slow];//慢指针一次走 1 步
            fast = nums[nums[fast]];//快指针一次走 2 步
        }

        //相遇之后,slow从起点出发,fast从相遇点出发,都一次走一步
        slow = 0;

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
