package com.yc.dfs;

import java.util.ArrayList;

public class Solution7 {//相同的树

    public boolean isSameTree(TreeNode p, TreeNode q) {
        ArrayList<Integer> plist = new ArrayList<>();
        ArrayList<Integer> qlist = new ArrayList<>();
        dfs(p, plist);
        dfs(q, qlist);
        return plist.equals(qlist);
    }

    public void dfs(TreeNode node, ArrayList<Integer> list) {
        if (node == null) {
            list.add(0);
            return;
        }

        list.add(node.val);

        dfs(node.left, list);
        dfs(node.right, list);
    }

    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);

        TreeNode q = new TreeNode(1);
        q.right = new TreeNode(2);

        boolean sameTree = solution7.isSameTree(p, q);
        System.out.println(sameTree);
    }
}
