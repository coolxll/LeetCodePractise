package com.leetcode.tree;

import com.leetcode.helper.TreeHelper;
import com.leetcode.helper.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer upper, Integer lower) {
        if(root == null) return true;
        if(upper != null && root.val >= upper) return false;
        if(lower != null && root.val <= lower) return false;
        if(root.left != null && root.val <= root.left.val) return false;
        if(root.right != null && root.val >= root.right.val) return false;
        if(!isValidBST(root.left,root.val,lower)) {
            return false;
        }
        return isValidBST(root.right, upper, root.val);
    }

    public boolean isValidCBT(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        Queue<TreeNode> leafQueue = new ArrayDeque<>();
        boolean leafFlag = false;
        while(!queue.isEmpty()) {
            int length = queue.size();
            while(length > 0) { //一层
                TreeNode curr = queue.poll();
                if(leafFlag && !isLeafNode(curr)) return false;
                if (curr.left != null && curr.right != null) { //都不为空
                    queue.offer(curr.left);
                    queue.offer(curr.right);
                } else if (curr.left != null) { //左边有
                    queue.offer(curr.left);
                    leafFlag = true;
                } else if (curr.left == null && curr.right != null) { //左边没有右边有
                    return false;
                } else if (curr.left == null && curr.right == null) { //遇到叶子节点后面都是叶子节点
                    leafFlag = true;
                }
                length--;
            }
        }
        return true;
    }


    private boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

    @Test
    public void testCBT() {
        TreeNode root = TreeHelper.stringToTreeNode("[1,2,3,5,null,7,8]");
        boolean isValidCBT = isValidCBT(root);
        Assert.assertFalse(isValidCBT);
    }

    @Test
    public void test1() {
        TreeNode root = TreeHelper.stringToTreeNode("[1,2,3,null,null,7,8]");
        boolean isValidCBT = isValidCBT(root);
        Assert.assertFalse(isValidCBT);
    }
}
