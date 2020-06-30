package com.leetcode.tree;


import com.leetcode.helper.TreeHelper;
import com.leetcode.helper.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Solution94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        TreeNode curr = root;
        while (curr != null || !queue.isEmpty()) {
            while(curr != null) { //一路向左遍历
                queue.addLast(curr);
                curr = curr.left;
            }
            curr = queue.pollLast();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }

    @Test
    public void test() {
        TreeNode treeNode = TreeHelper.stringToTreeNode("[1,null,2,3]");
        List<Integer> list = inorderTraversal(treeNode);
        Assert.assertEquals(Arrays.asList(1,3,2),list);
    }
}
