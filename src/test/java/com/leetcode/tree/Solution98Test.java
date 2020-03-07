package com.leetcode.tree;

import com.leetcode.helper.TreeHelper;
import com.leetcode.number.Solution7;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution98Test {

    @Test
    public void isValidBST() {
        Solution98 solution98 = new Solution98();
        boolean validBST = solution98.isValidBST(TreeHelper.stringToTreeNode("[2,1,3]"));
        Assert.assertTrue(validBST);
    }

    @Test
    public void isValidBST1() {
        Solution98 solution98 = new Solution98();
        boolean validBST = solution98.isValidBST(TreeHelper.stringToTreeNode("[1,1]"));
        Assert.assertFalse(validBST);
    }

    @Test
    public void isValidBST2() {
        Solution98 solution98 = new Solution98();
        boolean validBST = solution98.isValidBST(TreeHelper.stringToTreeNode("[10,5,15,null,null,6,20]"));
        Assert.assertFalse(validBST);
    }

    @Test
    public void isValidBST3() {
        Solution98 solution98 = new Solution98();
        boolean validBST = solution98.isValidBST(TreeHelper.stringToTreeNode("[3,1,5,0,2,4,6,null,null,null,3]"));
        Assert.assertFalse(validBST);
    }

    @Test
    public void isValidBST4() {
        Solution98 solution98 = new Solution98();
        boolean validBST = solution98.isValidBST(TreeHelper.stringToTreeNode("[2147483647]"));
        Assert.assertTrue(validBST);
    }
}