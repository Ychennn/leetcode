package com.yc.offer_medium;

public class Solution9 {//表示数值的字符串⭐⭐⭐⭐⭐⭐⭐

    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;

        //标记是否遇到数位,小数点,'e'或'E'
        boolean isNum = false, isDot = false, ise_or_E = false;

        //删除字符串头尾的空格,转为字符数组
        char[] arr = s.trim().toCharArray();

        for (int i = 0; i < arr.length; i++) {
            //判断当前字符是否数位
            if (Character.isDigit(arr[i])) {
                isNum = true;
            } else if (arr[i] == '.') {//遇到小数点
                //小数点之前可以没有整数,但是不能重复出现小数点,或出现'e'或'E'
                if (isDot || ise_or_E) return false;

                isDot = true;//标记已经遇到小数点
            } else if (arr[i] == 'e' || arr[i] == 'E') {//遇到'e'或'E'
                //'e'或'E'前面必须有整数,且前面不能重复出现'e'或'E'
                if (!isNum || ise_or_E) return false;

                //标记已经遇到'e'或'E'
                ise_or_E = true;

                //重置isNum,因为'e'或'E'之后也必须接上整数
                //防止出现 123e或者123e+的非法情况
                isNum = false;
            } else if (arr[i] == '-' || arr[i] == '+') {
                //正负号只能出现在第一个位置,或者出现在'e'或'E'的后面一个位置
                if (i != 0 && arr[i - 1] != 'e' && arr[i - 1] != 'E')
                    return false;
            } else return false;//其它情况均为不合法字符串
        }
        return isNum;
    }

    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
        //".5","-.5","+.5","3."均合法
        boolean b = solution9.isNumber("3.14159e10");
        System.out.println(b);
    }
}
