package com.yc.top_easy;

import java.util.ArrayList;
import java.util.List;

public class Solution13 {//Fizz Buzz

    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            boolean divisibleBy3 = (i % 3 == 0);
            boolean divisibleBy5 = (i % 5 == 0);
            StringBuilder stb = new StringBuilder();

            if (divisibleBy3) {
                stb.append("Fizz");
            }
            if (divisibleBy5) {
                stb.append("Buzz");
            }

            if (stb.length() == 0) {
                stb.append(i);
            }
            res.add(new String(stb));
        }

        return res;
    }

    public static void main(String[] args) {
        Solution13 solution13 = new Solution13();
        List<String> list = solution13.fizzBuzz(15);
        System.out.println(list);
    }
}
