package com.leetcode.tree;

import com.leetcode.helper.TreeNode;

import java.util.ArrayDeque;

public class Solution513 {

    public int findBottomLeftValue(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque();
        queue.add(root);
        TreeNode node = null;
        while (!queue.isEmpty()) {
            node = queue.pop();
            if (node.right != null) {
                queue.add(node.right);
            }
            if (node.left != null) {
                queue.add(node.left);
            }
        }
        return node.val;
    }
}
