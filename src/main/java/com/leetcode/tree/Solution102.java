package com.leetcode.tree;

import com.leetcode.helper.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int l = q.size(); //多加一层循环
            List<Integer> list = new ArrayList<>();
            while(l > 0) {
                TreeNode node = q.poll();
                list.add(node.val);
                l--;
                if(node.left != null) {q.offer(node.left);}
                if(node.right != null) {q.offer(node.right);}
            }
            result.add(list);
        }
        return result;
    }
}
