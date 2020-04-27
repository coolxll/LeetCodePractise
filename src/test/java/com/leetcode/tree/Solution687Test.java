package com.leetcode.tree;

import com.leetcode.helper.TreeHelper;
import com.leetcode.helper.TreeNode;
import org.junit.Test;

public class Solution687Test {

    Solution687 solution687 = new Solution687();

    @Test
    public void longestUnivaluePath() {
        TreeNode treeNode = TreeHelper.stringToTreeNode("[5,4,5,1,1,5]");
        int longestPath = solution687.longestUnivaluePath(treeNode);
        System.out.println(longestPath);
    }
}