package com.leetcode.tree;

import com.leetcode.helper.TreeNode;

import java.util.Arrays;

public class Solution106 {

    /**
     *
     * @param inorder 中序遍历
     * @param postorder 后序遍历
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = null;
        int l = postorder.length;
        if(l == 0) return null;
        int val = postorder[l-1];
        root = new TreeNode(val);
        int index = 0;
        for (int i = l - 1; i > 0; i--) {
            if(inorder[i] == val) {
                index = i;
                break;
            }
        }
        root.left = buildTree(Arrays.copyOfRange(inorder,0,index),Arrays.copyOfRange(postorder,0,index));
        root.right = buildTree(Arrays.copyOfRange(inorder,index+1,l),Arrays.copyOfRange(postorder,index,l-1));
        return root;
    }
}
