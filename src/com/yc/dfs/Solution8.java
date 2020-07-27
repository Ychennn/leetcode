package com.yc.dfs;

import java.util.HashMap;
import java.util.List;

public class Solution8 {//员工的重要性

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {//dfs
        //多次遍历效率低,用map保存节点
        HashMap<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        int sum = dfs(employees, map, id);
        return sum;
    }

    public int dfs(List<Employee> employees, HashMap<Integer, Employee> map, int id) {
        Employee root = map.get(id);
        int sum = root.importance;
        for (Integer subordinate : root.subordinates) {
            sum += dfs(employees, map, subordinate);
        }
        return sum;
    }
}

