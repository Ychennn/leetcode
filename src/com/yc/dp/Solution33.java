package com.yc.dp;

public class Solution33 {//分割等和子集

    //左右指针法对[1,2,3,4,5,6,7]失败-->(1,2,3,7),(4,5,6)
    public static boolean canPartition(int[] nums) {//动态规划
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) return false;//判断奇偶，奇数直接 返回
        int target = sum / 2;
        boolean[][] dp = new boolean[len][sum / 2 + 1];//把零的位置留出来
        //dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];循环i从1开始
        if (nums[0] <= target) dp[0][nums[0]] = true;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                //如果dp[i - 1][j]为true可以选择不添加nums[i],也符合条件,这步可以省略,下面有重复该步骤
                dp[i][j] = dp[i - 1][j];

                //dp[i][j]表示从数组的[0, i]这个子区间内挑选一些正整数,每个数只能用一次,使得这些数的和恰好等于j。
                if (nums[i] == j) {//当nums[i]和j直接 相等时,直接为true,跳出循环
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[len - 1][target];
    }

    public static boolean canPartition2(int[] nums) {//改变初始状态
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) return false;
        int target = sum / 2;

        boolean[][] dp = new boolean[len][target + 1];
        // 初始化成为 true 虽然不符合状态定义，但是从状态转移来说是完全可以的
        dp[0][0] = true;//这一步是为了解决nums[i] == j--->dp[i][j] = true;直接使用dp[i - 1][j - nums[i]]判断

        if (nums[0] <= target) dp[0][nums[0]] = true;

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < target + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }

                if (dp[i][target]) {
                    return true;
                }//如果有满足条件的，提前返回，减少循环次数,上面方法一也可以加这一步减少循环次数
            }
        }
        return false;//return dp[len - 1][target];也可以
    }

    public static boolean canPartition3(int[] nums) {//空间优化
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) return false;//判断奇偶，奇数直接 返回
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        if (nums[0] <= target) dp[nums[0]] = true;//<= 防止{1,1}类似

        for (int i = 1; i < len; i++) {
            for (int j = target; nums[i] <= j; j--) {//j = target; nums[i] <= j 如果j>nums[i]直接下一个循环
                //为什么采用倒序，防止前面的结果的改变对后面造成影响
                //如{2, 2, 3, 5}求值为6的dp[6]
                // 第一轮 i=0 --dp[0]=0 dp[nums[0]] --->dp[2]=true
                //第二轮 i=1 j=4 --dp[4] = dp[4]||dp[4-nums[1]] = dp[2] =true
                //第二轮 i=1 j=6 --dp[6] = dp[6]||dp[6-nums[1]] = dp[4] =true
                //结果显然为错的,因为前面的结果对后面的计算产生了影响
                //而倒序时i=1 j=6 --dp[6] = dp[6]||dp[6-nums[1]] = dp[4] =false正确
                //i=1 j=4 --dp[4] = dp[4]||dp[4-nums[1]] = dp[2] =true正确
                if (dp[target]) {
                    return true;
                }

                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return false;//return dp[target];也可以
    }

    public static void main(String[] args) {
//        boolean b = canPartition3(new int[]{1, 2, 3, 4, 5, 6, 7});
        boolean b = canPartition3(new int[]{1, 1});
        System.out.println(b);
    }
}
