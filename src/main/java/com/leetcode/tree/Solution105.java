package com.leetcode.tree;

import com.leetcode.helper.TreeNode;

import java.util.Arrays;

public class Solution105 {

    /**
     *
     * @param preorder 前序遍历
     * @param inorder 中序遍历
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = null;
        int l = preorder.length;
        if(l == 0) return null;
        if(inorder.length != l) return null; //Fail Fast, Although this type of input should not exist
        int val = preorder[0];
        root = new TreeNode(val);
        int index = 0;
        for(int i=0;i<l;i++) {
            if(inorder[i] == val) {
                index = i;
                break;
            }
            //Split preorder into two part,first part is left, second part is right
        }
        root.left = buildTree(Arrays.copyOfRange(preorder,1,index+1), Arrays.copyOfRange(inorder,0,index));
        root.right = buildTree(Arrays.copyOfRange(preorder,index+1,l),Arrays.copyOfRange(inorder,index+1,l));
        return root;
    }
}
