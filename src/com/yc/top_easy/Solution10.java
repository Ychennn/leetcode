package com.yc.top_easy;

import java.util.HashSet;

public class Solution10 {//快乐数⭐⭐⭐⭐

    private int getNext(int n) {//获取下一个数
        int sum = 0;
        while (n != 0) {
            int i = n % 10;
            sum += i * i;
            n /= 10;
        }
        return sum;//如19 -> 1*1 + 9*9 = 82
    }

    public boolean isHappy2(int n) {//hashSet
        HashSet<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {//如果存在循环,说明不可能经过变换变为1
            set.add(n);
            n = getNext(n);
        }

        //此时比较n是否为1
        return n == 1;
    }

    public boolean isHappy(int n) {//快慢指针⭐⭐⭐⭐⭐⭐⭐
        int slow = n;
        int fast = getNext(n);
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    public static void main(String[] args) {
        Solution10 solution10 = new Solution10();
        boolean b = solution10.isHappy(116);
        System.out.println(b);
    }
}
