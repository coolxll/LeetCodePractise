package com.leetcode.tree;

import com.leetcode.helper.TreeNode;

public class Solution572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null && t == null)
            return true;
        if(s == null && t != null)
            return false;
        if(isSubTreeWithRoot(s,t)) {
            return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right,t);
    }

    private boolean isSubTreeWithRoot(TreeNode s, TreeNode t) {
        if(s == null && t == null)
            return true;
        if(s == null && t != null)
            return false;
        if(t == null ||s.val != t.val) {
            return false;
        } else {
            return isSubTreeWithRoot(s.left, t.left) && isSubTreeWithRoot(s.right, t.right);
        }
    }
}
