package com.leetcode.tree;

import com.leetcode.helper.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 翻转二叉树
 */
public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        TreeNode leftReversed = invertTree(root.left);
        TreeNode rightReversed = invertTree(root.right);
        root.left = rightReversed;
        root.right = leftReversed;
        return root;
    }

    //BFS
    public TreeNode inverseTreeIteration(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }
}
