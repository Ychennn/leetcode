package com.yc.greedy;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution16 {//根据身高重建队列⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public int[][] reconstructQueue(int[][] people) {

        //对people二维数组依照降序,
        //people[i][0]相等时按照people[i][1]升序排序
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        //先解决高个子的,因为后面矮个子的添加对原先的高个子并无影响,
        //因为people[i][1]是记录排在这个人前面且身高大于或等于people[i][0]的人数
        LinkedList<int[]> linkedList = new LinkedList();

        //遍历排序后的数组,依照people[i][1]的值为索引添加至linkedList
        //插入频繁,选用linkedList
        for (int[] person : people) {
            linkedList.add(person[1], person);
        }
        //转换为二维数组,返回
        return linkedList.toArray(new int[people.length][2]);
    }

    public static void main(String[] args) {
        Solution16 solution16 = new Solution16();
        int[][] people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] ints = solution16.reconstructQueue(people);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }
}
