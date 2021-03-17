package com.leetcode.tree;

import com.leetcode.helper.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution101 {
//    public boolean isSymmetric(TreeNode root) {
//        if(root == null) return true;
//        return isSymmetric(root.left, root.right);
//    }
//
//    private boolean isSymmetric(TreeNode t1,TreeNode t2) {
//        //do not forget to consider the null condition
//        if(t1 == null && t2 == null) return true;
//        else if (t1 == null || t2 == null) return false;
//
//        if(t1.val != t2.val) return false;
//        else {
//            boolean b = isSymmetric(t1.left, t2.right);
//            boolean b1 = isSymmetric(t1.right,t2.left);
//            return b && b1;
//        }
//    }

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if(t1==null && t2 == null) continue;
            if(t1==null || t2 == null) return false;
            if(t1.val != t2.val) return false;
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }

        return true;

    }
}
