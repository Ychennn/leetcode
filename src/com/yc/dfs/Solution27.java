package com.yc.dfs;

import java.util.ArrayList;
import java.util.List;

public class Solution27 {//在每个树行中找最大值
    private List<Integer> result = new ArrayList<>();

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return result;
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) return;

        depth += 1;

        //当第一次来到depth深度时,将node.val值加入list中
        if (depth == result.size() + 1) {
            result.add(node.val);
        } else {//第二次及以后,将值取出来和当前节点的值比较后,将原来位置的值替换为较大值
            result.set(depth - 1, Math.max(result.get(depth - 1), node.val));
        }

        dfs(node.left, depth);
        dfs(node.right, depth);
    }

    public static void main(String[] args) {
        Solution27 solution27 = new Solution27();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        List<Integer> list = solution27.largestValues(root);
        System.out.println(list);
    }
}
