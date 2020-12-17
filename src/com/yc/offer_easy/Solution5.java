package com.yc.offer_easy;

public class Solution5 {//替换空格

    public String replaceSpace2(String s) {//库函数
        String res = s.replace(" ", "%20");
        return res;
    }

    public String replaceSpace(String s) {
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') res.append("%20");
            else res.append(c);
        }
        return new String(res);
    }
}
