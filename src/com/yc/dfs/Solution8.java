package com.yc.dfs;

import java.util.List;

public class Solution8 {//员工的重要性

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        Employee root = null;//id可能不存在

        for (Employee employee : employees) {
            if (employee.id == id) {
                root = employee;
                break;
            }
        }

        int sum = root.importance;

        for (Integer subordinate : root.subordinates) {
            sum += getImportance(employees, subordinate);
        }

        return sum;
    }
}

