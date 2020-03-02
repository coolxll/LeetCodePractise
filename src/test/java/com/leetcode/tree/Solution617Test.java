package com.leetcode.tree;

import com.leetcode.helper.TreeHelper;
import com.leetcode.helper.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution617Test {

    Solution617 solution617 = new Solution617();

    @Test
    public void mergeTrees() {
        TreeNode t1 = TreeHelper.stringToTreeNode("[1,3,2,5]");
        TreeNode t2 = TreeHelper.stringToTreeNode("[2,1,3,null,4,null,7]");
        TreeNode t3 = solution617.mergeTrees(t1, t2);
        String nodeToString = TreeHelper.treeNodeToString(t3);
        System.out.println(nodeToString);
        Assert.assertEquals("[3,4,5,5,4,null,7]",nodeToString);
    }
}