package com.yc.offer_easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution16 {//扑克牌中的顺子⭐⭐⭐⭐

    public boolean isStraight2(int[] nums) {//hash
        Set<Integer> set = new HashSet<>();
        //0 -> "大小王",13 -> "k",1 -> "A"
        int min = 14, max = 0;

        for (int num : nums) {
            //大小王跳过(可以替代任意牌)
            if (num == 0) continue;

            //如果出现2张大小一样的情况,肯定不能作出顺子
            if (set.contains(num)) return false;

            max = Math.max(max, num);//更新最大最小的牌
            min = Math.min(min, num);

            set.add(num);
        }
        return max - min < 5;//⭐⭐⭐⭐⭐
    }

    public boolean isStraight(int[] nums) {//排序
        int joker = 0;
        Arrays.sort(nums);
        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) joker++; //统计大小王数量
            else if (nums[i] == nums[i + 1]) return false;//若有重复,提前返回 false
        }
        return nums[4] - nums[joker] < 5; //最大牌-最小牌 < 5 则可构成顺子
    }
}
