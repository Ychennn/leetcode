package com.yc.dac;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {//求众数2

    public List<Integer> majorityElement(int[] nums) {
        //因为出现次数>1/3的数最多只存在两个
        int cand1 = 0, cnt1 = 0;
        int cand2 = 0, cnt2 = 0;

        for (int num : nums) {
            if (num == cand1) {
                cnt1++;
                continue;//每一步的continue是防止cand1和cand2的互相干扰
            }

            if (num == cand2) {
                cnt2++;
                continue;
            }

            if (cnt1 == 0) {
                cand1 = num;
                cnt1 = 1;
                continue;
            }

            if (cnt2 == 0) {
                cand2 = num;
                cnt2 = 1;
                continue;
            }

            //当前数不是二者之其一,才会进行到这一步
            cnt1--;
            cnt2--;

        }

        List<Integer> res = new ArrayList<>();

        //还需一次遍历判断候选是否为众数
        cnt1 = cnt2 = 0;
        for (int num : nums) {
            if (num == cand1) {
                cnt1++;
            } else if (num == cand2) {
                cnt2++;
            }
        }
        if (cnt1 > nums.length / 3)
            res.add(cand1);
        if (cnt2 > nums.length / 3)
            res.add(cand2);

        return res;
    }


    public static void main(String[] args) {
        Solution2 soulution2 = new Solution2();
        int[] nums = new int[]{1, 2, 1};
        List<Integer> res = soulution2.majorityElement(nums);
        System.out.println(res);
    }
}
