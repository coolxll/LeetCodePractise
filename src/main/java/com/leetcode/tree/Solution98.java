package com.leetcode.tree;

import com.leetcode.helper.TreeNode;

public class Solution98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer upper, Integer lower) {
        if(root == null) return true;
        if(upper != null && root.val >= upper) return false;
        if(lower != null && root.val <= lower) return false;
        if(root.left != null && root.val <= root.left.val) return false;
        if(root.right != null && root.val >= root.right.val) return false;
        if(!isValidBST(root.left,root.val,lower)) {
            return false;
        }
        if(!isValidBST(root.right,upper,root.val)) {
            return false;
        }
        return true;
    }

}
