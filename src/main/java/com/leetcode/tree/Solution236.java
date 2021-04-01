package com.leetcode.tree;

import com.leetcode.helper.TreeNode;

public class Solution236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;
        if(root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left != null && right != null) { //都是root的子节点，刚好是root.left 和 root.right
            return root;
        }
        if(left != null) {
            return left;
        }
        return right;
    }
}
