package com.yc.dfs;

import java.util.Arrays;
import java.util.List;

public class Solution29 {//钥匙和房间⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        //标记房间是否被访问过
        boolean[] isVisited = new boolean[rooms.size()];

        dfs(rooms, 0, isVisited);

        for (boolean flag : isVisited) {
            if (!flag) return false;
        }
        return true;
    }

    private void dfs(List<List<Integer>> rooms, int index, boolean[] isVisited) {
        if (!isVisited[index]) {
            isVisited[index] = true;

            for (Integer num : rooms.get(index)) {
                dfs(rooms, num, isVisited);
            }
        }
    }
}
