package com.yc.dfs;

public class Solution23 {//字符串解码⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public String decodeString(String s) {
        return dfs(s, 0)[0];
    }

    /**
     * @param s     待解码的字符串
     * @param index 当前的s从index开始
     * @return 返回值第一个为结果字符串, 第二个为当前轮结束的index值
     */
    private String[] dfs(String s, int index) {
        StringBuilder res = new StringBuilder();

        int count = 0;//重复的次数

        while (index < s.length()) {
            if (s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                count = count * 10 + Integer.parseInt(String.valueOf(s.charAt(index)));
            } else if (s.charAt(index) == '[') {
                String[] tmp = dfs(s, index + 1);
                index = Integer.parseInt(tmp[1]);
                System.out.println(index);

                while (count > 0) {
                    res.append(tmp[0]);
                    count--;
                }
            } else if (s.charAt(index) == ']') {
                return new String[]{res.toString(), String.valueOf(index)};
            } else {//如a,b,c
                res.append(s.charAt(index));
            }
            index++;
        }
        return new String[]{res.toString(), String.valueOf(index)};
    }

    public static void main(String[] args) {
        Solution23 solution23 = new Solution23();
        String s = "3[a]2[bc]";
//        String s = "3[2[bc]]";
        String str = solution23.decodeString(s);
        System.out.println(str);
    }
}
