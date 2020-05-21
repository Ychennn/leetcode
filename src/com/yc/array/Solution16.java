package com.yc.array;

import java.util.ArrayList;
import java.util.List;

public class Solution16 {//可被5整除的二进制前缀
    public static List<Boolean> prefixesDivBy5(int[] A) {
        ArrayList<Boolean> booleans = new ArrayList();
        int tail = 0;
        for (int i : A) {
            tail = tail * 2 + i;
            tail = tail - 9 > 0 ? tail - 10 : tail;//防止数组过长，sum溢出，所有选用尾数比较。
            if (tail == 5 || tail == 0) {
                booleans.add(true);
            } else {
                booleans.add(false);
            }
        }
        return booleans;
    }

    public static void main(String[] args) {
        List<Boolean> booleans = prefixesDivBy5(new int[]{0, 1, 1, 1, 1, 1});
        System.out.println(booleans);
    }
}