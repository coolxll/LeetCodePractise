package com.leetcode.tree;

import com.leetcode.helper.TreeHelper;
import com.leetcode.helper.TreeNode;
import org.junit.Test;

public class Solution111Test {

    @Test
    public void minDepth() {
        Solution111 solution111 = new Solution111();
        TreeNode treeNode = TreeHelper.stringToTreeNode("[3,9,20,null,null,15,7]");
        int i = solution111.minDepth(treeNode);
        System.out.println(i);
    }
}