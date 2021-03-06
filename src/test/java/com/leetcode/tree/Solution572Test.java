package com.leetcode.tree;

import com.leetcode.helper.TreeHelper;
import com.leetcode.helper.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class Solution572Test {

    @Test
    public void isSubtree() {
        Solution572 solution572 = new Solution572();
        TreeNode s = TreeHelper.stringToTreeNode("[3,4,5,1,2]");
        TreeNode t = TreeHelper.stringToTreeNode("[4,1,2]");
        boolean subtree = solution572.isSubtree(s, t);
        Assert.assertTrue(subtree);
    }

    @Test
    public void isSubtree1() {
        Solution572 solution572 = new Solution572();
        TreeNode s = TreeHelper.stringToTreeNode("[3,4,5,1,2,null,null,0]");
        TreeNode t = TreeHelper.stringToTreeNode("[4,1,2]");
        boolean subtree = solution572.isSubtree(s, t);
        Assert.assertFalse(subtree);
    }

    @Test
    public void isSubtree2() {
        Solution572 solution572 = new Solution572();
        TreeNode s = TreeHelper.stringToTreeNode("[1,2,3,4,5,6,7,null,8,9]");
        TreeNode t = TreeHelper.stringToTreeNode("[2,4,5,null,8,9]");
        boolean subtree = solution572.isSubtree(s, t);
        Assert.assertTrue(subtree);
    }
}