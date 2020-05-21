package com.yc.dp;

import java.util.ArrayList;
import java.util.List;

public class Solution18 {//同的二叉搜素树II

    static class Solution {
        public static List<TreeNode> generateTrees(int n) {
            List<TreeNode>[] dp = new ArrayList[n + 1];
            dp[0] = new ArrayList();//!!!!!!!!!!!!!!!!!!!!!如果left或right为0，就会出现空指针异常
            if (n == 0) return dp[0];
            dp[0].add(null);//如果不加null，那么后面当left或right为0时，就不会执行for循环。而一旦left不执行，right也会被跳过。
            ArrayList<TreeNode> treeNodes = new ArrayList<>();
            treeNodes.add(new TreeNode(1));
            dp[1] = treeNodes;

            for (int i = 2; i <= n; i++) {
                ArrayList<TreeNode> tree = new ArrayList();
                for (int j = 1; j <= i; j++) {
                    for (TreeNode left : dp[j - 1]) {//左子树的长度
                        for (TreeNode right : dp[i - j]) {//右子树的长度
                            TreeNode treeNode = new TreeNode(j);
                            // 左子树直接连接。
                            treeNode.left = left;
                            /*克隆右子树并且加上偏差,否则会出现问题，如i=100,j=98前面的98可以直接获取，
                            但后面(98,100)却不能直接获取到,只有(1,2),于是将(1,2)子树的每个的值递归加98*/
                            treeNode.right = clone(right, j);
                            tree.add(treeNode);
                        }
                    }
                }
                dp[i] = tree;
            }
            return dp[n];
        }


        private static TreeNode clone(TreeNode n, int offset) {//递归的改变子树的值，都加上offset
            if (n == null) {
                return null;
            }
            TreeNode node = new TreeNode(n.val + offset);
            node.left = clone(n.left, offset);
            node.right = clone(n.right, offset);
            return node;
        }

        public static void main(String[] args) {
            List<TreeNode> treeNodes = generateTrees(2);
            for (TreeNode treeNode : treeNodes) {
                System.out.println(treeNode);
            }
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}