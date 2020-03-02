package com.leetcode.tree;

import com.leetcode.helper.TreeNode;

/**
 * Easy
 */
public class Solution687 {

    private int lup = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return lup;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        if(root.left != null && root.val == root.left.val)
            l = l + 1; //长度加1
        else
            l = 0;
        if(root.right != null && root.val == root.right.val)
            r = r + 1; //长度加1
        else
            r = 0;
        lup = Math.max(lup, l + r);
        return Math.max(l, r); //只能选择一边走
    }
}
