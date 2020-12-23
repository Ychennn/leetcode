package com.yc.offer_medium;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {//二叉树中和为某一值的路径⭐⭐⭐⭐⭐
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();//临时存放root.val

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return res;
    }

    private void dfs(TreeNode node, int cur) {
        if (node == null) return;
        path.add(node.val);
        cur -= node.val;

        if (cur == 0 && node.left == null && node.right == null) {
            res.add(new ArrayList<>(path));
        }

        dfs(node.left, cur);
        dfs(node.right, cur);

        cur += node.val;//回溯
        path.remove(path.size() - 1);
    }
}
