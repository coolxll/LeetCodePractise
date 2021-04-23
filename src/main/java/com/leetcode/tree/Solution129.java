package com.leetcode.tree;

import com.leetcode.helper.TreeNode;

public class Solution129 {

    public int sumNumbers(TreeNode root) {
        return sumHelper(root, 0);
    }

    private int sumHelper(TreeNode root, int parentVal) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return parentVal * 10 + root.val;
        int sum = 0;
        if(root.left != null) {
            sum += sumHelper(root.left, parentVal * 10 + root.val);
        }
        if(root.right != null) {
            sum += sumHelper(root.right, parentVal * 10 + root.val);
        }
        return sum;
    }
}
