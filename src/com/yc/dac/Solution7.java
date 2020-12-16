package com.yc.dac;

public class Solution7 {//二叉搜索树与双向链表⭐⭐⭐⭐⭐⭐

    Node pre, head;//前驱节点,头指针

    public Node treeToDoublyList(Node root) {
        if (root == null) return root;
        dfs(root);

        //头尾节点相互指向,通过dfs并未完成全部功能
        head.left = pre;
        pre.right = head;

        return head;
    }

    private void dfs(Node node) {//中序遍历,能满足有序
        if (node == null) return;

        dfs(node.left);
        if (pre == null) {//如果pre==null,代表cur左侧没有节点,即此时cur为双向链表中的头节点
            head = node;
        } else {//不为空,则将前驱节点的后继节点指向node(当前节点)
            pre.right = node;
        }
        node.left = pre;

        pre = node;//更新指针
        dfs(node.right);
    }
}
