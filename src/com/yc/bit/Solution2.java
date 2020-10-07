package com.yc.bit;

public class Solution2 {//数字转换为十六进制数⭐⭐⭐⭐⭐

    public String toHex(int num) {
        if (num == 0) return "0";//特殊处理

        char[] chars = "0123456789abcdef".toCharArray();

        StringBuilder res = new StringBuilder();
        while (num != 0) {
            int temp = num & 15;   //取低4位的十进制值
            res.append(chars[temp]);
            num >>>= 4;             //无符号右移,负数高位补0
        }
        //while的循环条件保证了不会出现前导0
        //但是从低位开始转换则多了一步reverse反转
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        String s = solution2.toHex(-1);
        System.out.println(s);
    }
}
