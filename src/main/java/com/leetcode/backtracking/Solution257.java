package com.leetcode.backtracking;

import com.alibaba.fastjson.JSON;
import com.leetcode.helper.TreeHelper;
import com.leetcode.helper.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs(result,root,"");
        return result;
    }

    private void dfs(List<String> result,TreeNode root,String prefix) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            result.add(prefix + root.val);
        } else {
            String newPrefix = "".equals(prefix) ? root.val + "->" : prefix + root.val + "->";
            if(root.left != null) {
                dfs(result, root.left, newPrefix);
            }
            if(root.right != null) {
                dfs(result,root.right, newPrefix);
            }
        }
    }

    @Test
    public void test() {
        List<String> binaryTreePaths = binaryTreePaths(TreeHelper.stringToTreeNode("[1,2,3,null,5]"));
        System.out.println(JSON.toJSON(binaryTreePaths));
    }

    @Test
    public void test_empty() {
        List<String> binaryTreePaths = binaryTreePaths(TreeHelper.stringToTreeNode("[]"));
        System.out.println(JSON.toJSON(binaryTreePaths));
    }
}
