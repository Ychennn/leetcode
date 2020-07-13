package com.yc.dfs;

import java.util.ArrayList;

public class Solution4 {//叶子相似的树

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        dfs(root1, list);
        dfs(root2, list2);

        return list.equals(list2);
    }
    
    public void dfs(TreeNode node, ArrayList arrayList) {
        if (node.left == null && node.right == null) {
            arrayList.add(node.val);
            return;
        }

        if (node.left != null) dfs(node.left, arrayList);
        if (node.right != null) dfs(node.right, arrayList);
    }
}
