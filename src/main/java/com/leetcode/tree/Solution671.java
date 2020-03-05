package com.leetcode.tree;

import com.leetcode.helper.TreeNode;

public class Solution671 {
    public int findSecondMinimumValue(TreeNode root) {
        //发现提前终止条件是value = root.val 是关键
        if(root == null) return -1;
        if(root.left == null && root.right == null) return -1;
        int leftValue = root.left.val;
        int rightValue = root.right.val;
        if(leftValue == root.val) { //否则不用继续递归了
            leftValue = findSecondMinimumValue(root.left);
        }
        if(rightValue == root.val) {
            rightValue = findSecondMinimumValue(root.right);
        }
        if(leftValue != -1 && rightValue != -1) {
            return Math.min(leftValue, rightValue);
        }
        if(leftValue != -1) {
            return leftValue;
        } else {
            return rightValue;
        }
    }
}
