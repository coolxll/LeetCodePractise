package com.leetcode.tree;

import com.leetcode.helper.TreeNode;

public class Solution404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        int sum = 0;
        sum = sum + (isLeaf(root.left) ? root.left.val : sumOfLeftLeaves(root.left));
        return sum + sumOfLeftLeaves(root.right);
    }

    private boolean isLeaf(TreeNode node) {
        if(node == null) return false;
        return node.left == null && node.right == null;
    }
}
