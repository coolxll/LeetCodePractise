package com.leetcode.tree;

import com.leetcode.helper.TreeHelper;
import com.leetcode.helper.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class Solution543Test {

    Solution543 solution543 = new Solution543();

    @Test
    public void diameterOfBinaryTree() {
        TreeNode tree = TreeHelper.stringToTreeNode("[4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2]");
        int diameterOfBinaryTree = solution543.diameterOfBinaryTree(tree);
        System.out.println(diameterOfBinaryTree);
        Assert.assertEquals(8,diameterOfBinaryTree);
    }
}