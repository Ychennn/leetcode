package com.yc.offer_medium;

public class Solution6 {//二叉搜索树的后序遍历序列⭐⭐⭐⭐⭐

    public boolean verifyPostorder(int[] postorder) {
        return helper(postorder, 0, postorder.length - 1);
    }

    private boolean helper(int[] postorder, int l, int r) {//递归⭐⭐⭐⭐⭐⭐
        //如果left==right,就一个节点不需要判断,如果left>right说明没有节点,也无需判断
        if (l >= r) return true;

        //因为数组中最后一个值postorder[right]是根节点,这里从左往右找出第一个比
        //根节点大的值,他后面的都是根节点的右子节点(包含当前值,不包含最后一个值
        //因为最后一个是根节点),他前面的都是根节点的左子节点
        int mid = l;
        int rootVal = postorder[r];
        while (postorder[mid] < rootVal) mid++;

        //因为postorder[mid]前面的值都是比根节点root小的
        //我们还需要确定postorder[mid]后面的值都要比根节点root大
        //如果后面有比根节点小的直接返回false
        int tmp = mid;
        while (tmp < r) {
            if (postorder[tmp++] < rootVal) return false;
        }

        //对左右子节点进行递归调用
        return helper(postorder, l, mid - 1) && helper(postorder, mid, r - 1);
    }
}
