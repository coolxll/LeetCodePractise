package com.leetcode.tree;

import com.leetcode.helper.TreeHelper;
import com.leetcode.helper.TreeNode;
import com.leetcode.tree.Solution110;
import org.junit.Assert;
import org.junit.Test;

public class Solution110Test {
    Solution110 solution110 = new Solution110();

    @Test
    public void isBalanced() {
        TreeNode tree = TreeHelper.stringToTreeNode("[3,9,20,null,null,15,7]");
        boolean balanced = solution110.isBalanced(tree);
        Assert.assertTrue(balanced);
    }

    @Test
    public void isBalanced1() {
        TreeNode tree = TreeHelper.stringToTreeNode("[]");
        boolean balanced = solution110.isBalanced(tree);
        Assert.assertTrue(balanced);
    }

    @Test
    public void isBalanced2() {
        TreeNode tree = TreeHelper.stringToTreeNode("[1,2,2,3,null,null,3,4,null,null,4]");
        boolean balanced = solution110.isBalanced(tree);
        Assert.assertFalse(balanced);
    }
}