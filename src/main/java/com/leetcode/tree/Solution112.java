package com.leetcode.tree;

import com.leetcode.helper.TreeNode;

public class Solution112 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.val == sum && root.left == null && root.right == null) return true; //必须为叶子节点
        return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
    }
}
