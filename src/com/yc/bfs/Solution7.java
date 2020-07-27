package com.yc.bfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution7 {
    private static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {//bfs
        if (employees == null) return 0;

        //多次遍历效率低,用map保存节点
        HashMap<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        Queue<Employee> queue = new LinkedList<>();
        queue.add(map.get(id));
        int sum = 0;
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                Employee employee = queue.poll();
                sum += employee.importance;

                for (Integer subordinate : employee.subordinates) {
                    queue.add(map.get(subordinate));
                }
            }
        }

        return sum;
    }
}
