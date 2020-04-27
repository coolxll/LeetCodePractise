package com.leetcode.tree;

import com.leetcode.helper.TreeHelper;
import com.leetcode.helper.TreeNode;
import org.junit.Test;

public class Solution572Test {

    @Test
    public void isSubtree() {
        Solution572 solution572 = new Solution572();
        TreeNode s = TreeHelper.stringToTreeNode("[3,4,5,1,2]");
        TreeNode t = TreeHelper.stringToTreeNode("[4,1,2]");
        boolean subtree = solution572.isSubtree(s, t);
        System.out.println(subtree);
    }
}