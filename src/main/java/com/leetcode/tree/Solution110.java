package com.leetcode.tree;

import com.leetcode.helper.TreeNode;

/**
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * 任意两个节点
 */
public class Solution110 {

    /**
     * O(n) + 2*O(n/2) + 4O(n/4)
     * Time: O(nlogn)
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int leftHeight = getHeight(root.left);
        if(leftHeight == -1) return false;
        int rightHeight = getHeight(root.right);
        if(rightHeight == -1) return false;
        return getHeight(root) != -1;
    }

    /**
     * 遇到不平衡，直接返回-1
     * @param root
     * @return
     */
    private int getHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        if(leftHeight == -1) {
            return -1;
        }
        int rightHeight = getHeight(root.right);
        if(rightHeight == -1) {
            return -1;
        }
        if(Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
