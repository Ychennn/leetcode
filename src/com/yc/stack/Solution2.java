package com.yc.stack;

import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {//棒球比赛⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int calPoints(String[] ops) {
        Deque<Integer> stack = new LinkedList<>();//记录待操作的数

        int sum = 0;
        for (String op : ops) {
            if (op.equals("C")) {//弹出栈顶的数
                stack.poll();
            } else if (op.equals("D")) {//栈顶添加上一个数的2倍
                stack.addFirst(stack.peek() * 2);
            } else if (op.equals("+")) {//栈顶添加上一个和上上个的待操作数之和
                int top = stack.poll();//先弹出栈顶的数并记录
                int newTop = top + stack.peek();//获取上一步和上上步的数之和
                stack.addFirst(top);//还原操作
                stack.addFirst(newTop);//栈顶添加之和
            } else {//栈顶添加待操作的数
                stack.addFirst(Integer.valueOf(op));
            }
        }

        //遍历求和,也可以将运算操作放在循环里面
        for (Integer num : stack) sum += num;
        return sum;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        String[] ops = {"5", "2", "C", "D", "+"};
        int i = solution2.calPoints(ops);
        System.out.println(i);
    }
}
