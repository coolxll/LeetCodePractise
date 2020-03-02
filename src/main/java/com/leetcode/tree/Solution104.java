package com.leetcode.tree;


import com.leetcode.helper.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 *
 * for example if input is [3,9,20,null,null,15,7]， then output is 3
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 */
public class Solution104 {
    public int maxDepth(TreeNode root) {
        int leftDepth = 0,rightDepth = 0;
        if (root == null) return 0;
        leftDepth = maxDepth(root.left);
        rightDepth = maxDepth(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
