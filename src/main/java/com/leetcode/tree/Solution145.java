package com.leetcode.tree;

import com.leetcode.helper.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        List<Integer> output = new ArrayList<>();
        if (root == null) {
            //You may call it fast-fail
            return output;
        }
        q.add(root);
        while (!q.isEmpty()) { //类似BFS遍历
            TreeNode treeNode = q.pollLast();
            output.add(treeNode.val);
            if (treeNode.left != null) {
                q.add(treeNode.left);
            }
            if (treeNode.right != null) {
                q.add(treeNode.right);
            }
        }
        Collections.reverse(output);
        return output;
    }
}
