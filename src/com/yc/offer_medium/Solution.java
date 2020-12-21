package com.yc.offer_medium;

public class Solution {//求1+2+…+n⭐⭐⭐⭐⭐

    //规定不能使用*,/,if/else,for,while,switch,case
    public int sumNums(int n) {
        //利用与的短路现象,如果前面条件失败,后续条件不再判断(执行)
        boolean b = n > 1 && ((n += sumNums(n - 1)) > 0);
        return n;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int sum = solution.sumNums(2);
        System.out.println(sum);
    }
}
