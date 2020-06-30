package com.leetcode.tree;

import com.leetcode.helper.TreeHelper;
import com.leetcode.helper.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution144 {

    List<Integer> result = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if(root != null) {
            result.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return result;
    }

    public List<Integer> preorderTraversal1(TreeNode root) {
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
            if (treeNode.right != null) {
                q.add(treeNode.right);
            }
            if (treeNode.left != null) {
                q.add(treeNode.left);
            }
        }
        return output;
    }

    @Test
    public void test() {
        TreeNode treeNode = TreeHelper.stringToTreeNode("[3,1,2]");
        List<Integer> list = preorderTraversal1(treeNode);
        Assert.assertEquals(Arrays.asList(3,1,2),list);
    }

}
