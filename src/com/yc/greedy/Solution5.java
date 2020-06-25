package com.yc.greedy;

class Solution5 {//柠檬水找零⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public boolean lemonadeChange(int[] bills) {
        int five = 0;//记录5元零钱的个数
        int ten = 0;//记录10元零钱的个数

        //每一次分三种情况讨论
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {//如果当前实付5元
                five++;
            } else if (bills[i] == 10) {//如果当前实付10元
                if (five == 0) return false;
                ten++;
                five--;
            } else if (bills[i] == 20) {//如果当前实付20元
                if (five == 0) return false;

                if (five > 0 && ten > 0) {//优先考虑,用10元和5元的搭配找零⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        int[] bills = new int[]{5, 5, 5, 10, 20};
        boolean b = solution5.lemonadeChange(bills);
        System.out.println(b);
    }
}
