package com.leetcode.tree;

import com.leetcode.helper.TreeNode;
import lombok.extern.slf4j.Slf4j;

/**
 * 双重递归
 */
@Slf4j
public class Solution437 {

    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        int count = calcCount(root,sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        return count;
    }

    private int calcCount(TreeNode root, int sum) {
        if(root == null) return 0;
        int ret = 0;
        if(root.val == sum)
            ret += 1;
        ret += calcCount(root.left, sum - root.val);
        ret += calcCount(root.right, sum - root.val);
        return ret;
    }
}
