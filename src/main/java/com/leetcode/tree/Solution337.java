package com.leetcode.tree;

import com.leetcode.helper.TreeNode;

//TODO:NEED TO BE OPTIMIZED
public class Solution337 {
    public int rob(TreeNode root) {
        if(root == null) return 0;
        int val1 = root.val; //从根节点开始rob的情况
        if(root.left != null) {
            val1 += rob(root.left.left) + rob(root.left.right);
        }
        if(root.right != null) {
            val1 += rob(root.right.left) + rob(root.right.right);
        }
        int val2 = rob(root.left) + rob(root.right);
        return Math.max(val1, val2);
    }
}
