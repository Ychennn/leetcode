package com.yc.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution17 {//电话号码的字母组合⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    //一个映射表，第二个位置是"abc“,第三个位置是"def"...
    //这里也可以用map，用数组可以更节省点内存
    String[] letter_map = {" ", "*", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"};

    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        //特殊判断
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        //用StringBuilder可以提高效率,但需要添加撤销操作
        StringBuilder stb = new StringBuilder();
        iterStr(digits, stb, 0);
        return result;
    }

    /**
     * @param digits 目标字符串,即letterCombinations(.)的传入参数
     * @param stb    中间量,临时保存加入的字符
     * @param index  索引，表示当前进行到digits的第多少位
     */
    private void iterStr(String digits, StringBuilder stb, int index) {
        if (index == digits.length()) {
            result.add(stb.toString());
            return;
        }

        char c = digits.charAt(index);
        int num = c - '0';//获取对应index的int类型的数
        String s = letter_map[num];

        for (int i = 0; i < s.length(); i++) {
            iterStr(digits, stb.append(s.charAt(i)), index + 1);
            //撤销当前操作
            stb.deleteCharAt(stb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        List<String> list = solution17.letterCombinations("23");
        System.out.println(list);
    }
}
