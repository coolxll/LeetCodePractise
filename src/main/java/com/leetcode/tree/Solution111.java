package com.leetcode.tree;

import com.leetcode.helper.TreeNode;

/**
 * MinDepth
 */
public class Solution111 {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int leftDepth = 0, rightDepth = 0;
        if(root.left != null)
            leftDepth = minDepth(root.left);
        if(root.right != null)
            rightDepth = minDepth(root.right);
        if(leftDepth == 0 || rightDepth == 0) { //关键点！！！
            return 1 + leftDepth + rightDepth;
        } else {
            return 1 + Math.min(leftDepth,rightDepth);
        }
    }
}
