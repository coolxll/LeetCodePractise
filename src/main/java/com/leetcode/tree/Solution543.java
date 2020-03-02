package com.leetcode.tree;

import com.leetcode.helper.TreeNode;

/**
 *  最长路径 直径
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 */
public class Solution543 {

    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0; //空树
        dfs(root);
        return diameter;
    }

    /**
     * longest path
     * @param root
     * @return height of longest of left or right
     */
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        diameter = Math.max(diameter,l+r); //更新最大值
        return 1 + Math.max(l, r);
    }

}
