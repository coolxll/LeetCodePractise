package com.leetcode.tree;

import com.leetcode.helper.TreeHelper;
import com.leetcode.helper.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class Solution437Test {

    Solution437 solution437 = new Solution437();

    @Test
    public void pathSum() {
        TreeNode root = TreeHelper.stringToTreeNode("[10,5,-3,3,2,null,11,3,-2,null,1]");
        int i = solution437.pathSum(root, 8);
        Assert.assertEquals(3,i);
    }

    @Test
    public void pathSum1() {
        TreeNode root = TreeHelper.stringToTreeNode("[]");
        int i = solution437.pathSum(root, 1);
        Assert.assertEquals(0,i);
    }

    @Test
    public void pathSum2() {
        TreeNode root = TreeHelper.stringToTreeNode("[1,null,2,null,3,null,4,null,5]");
        int i = solution437.pathSum(root, 3);
        Assert.assertEquals(2,i);
    }
}