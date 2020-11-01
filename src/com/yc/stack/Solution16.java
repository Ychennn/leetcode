package com.yc.stack;

public class Solution16 {//逆波兰表达式求值⭐⭐⭐⭐⭐⭐⭐

    public int evalRPN(String[] tokens) {//数组模拟栈操作,大幅提升效率
        //因为运算符都是双目运算符,所以运算数字总会比运算符的数量多一个
        //运算数最多需要tokens.length / 2 + 1个长度就够了
        int[] numStack = new int[tokens.length / 2 + 1];
        int index = 0;//对应为栈顶索引
        for (String str : tokens) {
            switch (str) {
                case "+":
                    //该操作 => 弹出栈顶的2个元素,计算后将结果压入栈
                    numStack[index - 2] += numStack[--index];
                    break;
                case "-":
                    numStack[index - 2] -= numStack[--index];
                    break;
                case "*":
                    numStack[index - 2] *= numStack[--index];
                    break;
                case "/":
                    numStack[index - 2] /= numStack[--index];
                    break;
                default:
                    numStack[index++] = Integer.parseInt(str);
            }
        }
        return numStack[0];
    }


    public static void main(String[] args) {
        Solution16 solution16 = new Solution16();
        String[] tokens = {"2", "1", "+", "3", "*"};
        int i = solution16.evalRPN(tokens);
        System.out.println(i);
    }
}
