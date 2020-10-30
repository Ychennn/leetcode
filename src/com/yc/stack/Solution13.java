package com.yc.stack;

import java.util.*;

public class Solution13 {//简化路径⭐⭐⭐⭐⭐⭐⭐

    public String simplifyPath(String path) {
        String[] split = path.split("/");//用spilt将字符串以"/"分割为字符串数组

        Deque<String> stack = new LinkedList<>();//栈内只存取路径

        for (String s : split) {
            if (s.equals("..")) {//具体画图
                if (!stack.isEmpty()) stack.poll();
            } else if (s.length() != 0 && !s.equals(".")) {//遇到""或"."跳过
                stack.push(s);
            }
        }

        if (stack.isEmpty()) return "/";
        StringBuilder stb = new StringBuilder();

        for (String s : stack) {//因为栈倒序出栈,所以应插入到字符串的首部位置
            stb.insert(0, "/" + s);
        }
        return stb.toString();
    }

    public static void main(String[] args) {
        Solution13 solution13 = new Solution13();
        String s = "/a/./b/../../c/";
        String path = solution13.simplifyPath(s);
        System.out.println(path);
    }
}
