package com.yc.offer_medium;

import java.util.Arrays;

public class Solution4 {//n个骰子的点数

    public double[] dicesProbability(int n) {//动态规划
        //pre[0]为n个骰子每个点数为1的概率,如n=1时pre[0]为点数为1的概率
        //同理pre[pre.length-1]为n个骰子点数全部为6的概率
        //初始化pre数组
        double pre[] = {1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d};

        for (int i = 2; i <= n; i++) {
            //临时数组,n=2时,可能的点数为2-12,所以长度为2*5+1
            double[] tmp = new double[i * 5 + 1];
            for (int j = 0; j < pre.length; j++) {
                for (int k = 0; k < 6; k++) {
                    //概率推导公式为tmp[j+k]+=pre[j]*num[k];
                    //pre数组为n-1个骰子的点数概率数组
                    //num[k]为另拿一个骰子对应点数为k+1的概率
                    tmp[j + k] += pre[j] / 6;
                }
            }
            pre = tmp;
        }
        return pre;
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        double[] probability = solution4.dicesProbability(2);
        System.out.println(Arrays.toString(probability));
    }
}
