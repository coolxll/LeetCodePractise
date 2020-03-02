package com.leetcode.tree;

import com.leetcode.helper.TreeHelper;
import com.leetcode.helper.TreeNode;
import com.leetcode.tree.Solution104;
import org.junit.Assert;
import org.junit.Test;

public class Solution104Test {

    Solution104 solution104 = new Solution104();

    @Test
    public void maxDepth() {
        TreeNode treeNode = TreeHelper.stringToTreeNode("[3,9,20,null,null,15,7]");
        int depth = solution104.maxDepth(treeNode);
        System.out.println(depth);
        Assert.assertEquals(3,depth);
    }
}