package com.yc.stack;

import java.util.Deque;
import java.util.LinkedList;

class BSTIterator {//二叉搜索树迭代器⭐⭐⭐⭐⭐
    Deque<TreeNode> nodeStack;

    public BSTIterator(TreeNode root) {//也可以使用递归中序遍历
        nodeStack = new LinkedList<>();
        helper(root);//初始化将所有左子节点(包括根节点)压入栈中
    }

    public void helper(TreeNode node) {//画图
        while (node != null) {
            nodeStack.push(node);
            node = node.left;
        }
    }

    public int next() {//受控递归,调用到哪执行到哪
        //当调用该方法时,弹出栈顶的数返回,
        //并且将弹出节点的右子节点进行helper调用
        TreeNode pop = nodeStack.pop();
        if (pop.right != null) helper(pop.right);
        return pop.val;
    }

    public boolean hasNext() {
        return !nodeStack.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        BSTIterator iterator = new BSTIterator(root);
        boolean b = iterator.hasNext();
        System.out.println(b);
        System.out.println(iterator.next());
    }
}