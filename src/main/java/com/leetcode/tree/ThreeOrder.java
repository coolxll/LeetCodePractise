package com.leetcode.tree;

import com.alibaba.fastjson.JSON;
import com.leetcode.helper.TreeHelper;
import com.leetcode.helper.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ThreeOrder {

    public int[][] threeOrders (TreeNode root) {
        // write code here
        List<Integer> preOrderList = new ArrayList<>();
        preOrder(root,preOrderList);
        List<Integer> inOrderList = new ArrayList<>();
        inOrder(root,inOrderList);
        List<Integer> postOrderList = new ArrayList<>();
        postOrder(root,postOrderList);
        int l = preOrderList.size();
        int[][] result = new int[3][l];
        for(int i=0;i<l;i++) {
            result[0][i] = preOrderList.get(i);
            result[1][i] = inOrderList.get(i);
            result[2][i] = postOrderList.get(i);
        }
        return result;
    }

    private void preOrder(TreeNode root, List result) {
        result.add(root.val);
        if(root.left != null) {
            preOrder(root.left,result);
        }
        if(root.right != null) {
            preOrder(root.right,result);
        }
    }

    private void inOrder(TreeNode root, List result) {
        if(root.left != null) {
            inOrder(root.left,result);
        }
        result.add(root.val);
        if(root.right != null) {
            inOrder(root.right,result);
        }
    }

    private void postOrder(TreeNode root, List result) {
        if(root.left != null) {
            postOrder(root.left,result);
        }
        if(root.right != null) {
            postOrder(root.right,result);
        }
        result.add(root.val);
    }

    @Test
    public void test() {
        TreeNode treeNode = TreeHelper.stringToTreeNode("[1,2,3,4,5]");
        int[][] result = threeOrders(treeNode);
        System.out.println(JSON.toJSONString(result));
    }
}
